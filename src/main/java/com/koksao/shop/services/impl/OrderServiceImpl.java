package com.koksao.shop.services.impl;

import com.koksao.shop.domain.Customer;
import com.koksao.shop.domain.dto.OrderItemsRequest;
import com.koksao.shop.domain.dto.OrderItemsResponse;
import com.koksao.shop.domain.dto.OrderRequest;
import com.koksao.shop.domain.dto.OrderResponse;
import com.koksao.shop.domain.products.Order;
import com.koksao.shop.domain.products.OrderItems;
import com.koksao.shop.domain.products.Product;
import com.koksao.shop.mappers.OrderItemsMapper;
import com.koksao.shop.mappers.OrderMapper;
import com.koksao.shop.repositories.CustomerRepository;
import com.koksao.shop.repositories.OrderItemRepository;
import com.koksao.shop.repositories.OrderRepository;
import com.koksao.shop.repositories.ProductRepository;
import com.koksao.shop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderItemsMapper orderItemsMapper;

    @Autowired
    OrderItemRepository orderItemRepository;


    @Override
    public OrderResponse create(OrderRequest orderRequest, List<OrderItemsRequest> orderItemsRequests) {
        Optional<Customer> customer = customerRepository.findById(orderRequest.getCustomer_id());
        Order order = Order.builder()
                .customer(customer.get())
                .orderDate(orderRequest.getOrderDate())
                .build();
        Order savedOrder = orderRepository.save(order);
        List<OrderItems> orderItems = orderItemsRequests.stream()
                .map(orderItemRequest -> {
                    Optional<Product> product = productRepository.findById(orderItemRequest.getProduct_id());

                    OrderItems orderItem = OrderItems.builder()
                            .product(product.get())
                            .quantity(orderItemRequest.getQuantity())
                            .order(savedOrder)
                            .build();
                    product.ifPresent(p -> p.reduceAvailability(orderItemRequest.getQuantity()));
                    orderItemRepository.save(orderItem);

                    return orderItem;
                }).toList();

        savedOrder.setProducts(orderItems);
        List<OrderItemsResponse> responseItems = orderItemsMapper.mapToResponse(savedOrder.getProducts());
        return orderMapper.mapFrom(savedOrder, responseItems);
    }

    @Override
    public List<OrderResponse> findAll() {
        List<Order> orders = StreamSupport.stream(orderRepository
                                .findAll()
                                .spliterator(),
                        false)
                .toList();

        List<OrderResponse> orderResponses = orders.stream()
                .map(order -> OrderResponse.builder()
                        .products(orderItemsMapper.mapToResponse(order.getProducts()))
                        .customer_name(order.getCustomer().getFirstName())
                        .orderDate(order.getOrderDate())
                        .Id(order.getId())
                        .build())
                .toList();
        return orderResponses;
    }

    @Override
    public Order findById(Long id) {
        return null;
    }

    @Override
    public Order findByCustomerId(Long id) {
        return null;
    }
}
