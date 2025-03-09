package com.koksao.shop.mappers;

import com.koksao.shop.domain.dto.OrderItemsResponse;
import com.koksao.shop.domain.dto.OrderRequest;
import com.koksao.shop.domain.dto.OrderResponse;
import com.koksao.shop.domain.products.Order;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderMapper{

    private ModelMapper modelMapper;

    public OrderMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public Order mapTo(OrderRequest orderRequest) {
        return modelMapper.map(orderRequest, Order.class);
    }

    public OrderResponse mapFrom(Order order, List<OrderItemsResponse> responseItems) {
        OrderResponse orderResponse = OrderResponse.builder()
                .Id(order.getId())
                .customer_name(order.getCustomer().getFirstName())
                .orderDate(order.getOrderDate())
                .products(responseItems)
                .build();
        return orderResponse;
    }
}
