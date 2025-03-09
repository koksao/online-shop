package com.koksao.shop.services;

import com.koksao.shop.domain.dto.OrderItemsRequest;
import com.koksao.shop.domain.dto.OrderRequest;
import com.koksao.shop.domain.dto.OrderResponse;
import com.koksao.shop.domain.products.Order;

import java.util.List;

public interface OrderService {

    OrderResponse create(OrderRequest orderRequest, List<OrderItemsRequest> orderItemsRequests);

    List<OrderResponse> findAll();

    Order findById(Long id);

    Order findByCustomerId(Long id);
}
