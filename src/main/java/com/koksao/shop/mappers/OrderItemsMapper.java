package com.koksao.shop.mappers;

import com.koksao.shop.domain.dto.response.OrderItemsResponse;
import com.koksao.shop.domain.products.OrderItems;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderItemsMapper {

    public List<OrderItemsResponse> mapToResponse(List<OrderItems> orderItems) {
        List<OrderItemsResponse> responseItems = orderItems.stream()
                .map(orderItem -> {
                    OrderItemsResponse orderItemResponse = OrderItemsResponse.builder()
                            .product_id(orderItem.getProduct().getId())
                            .quantity(orderItem.getQuantity())
                            .price(orderItem.getProduct().getPrice())
                            .clothingSize(orderItem.getProduct().getClothingSize())
                            .material(orderItem.getProduct().getMaterial())
                            .build();
                    return orderItemResponse;
                }).toList();
        return responseItems;
    }
}
