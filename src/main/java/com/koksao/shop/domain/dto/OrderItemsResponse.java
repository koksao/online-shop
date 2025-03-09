package com.koksao.shop.domain.dto;

import com.koksao.shop.domain.products.ClothingSize;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderItemsResponse {

    Long product_id;

    int quantity;

    Double price;

    @Enumerated(EnumType.STRING)
    ClothingSize clothingSize;

    String material;

}
