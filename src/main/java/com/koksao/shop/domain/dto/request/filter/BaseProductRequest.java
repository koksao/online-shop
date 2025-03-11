package com.koksao.shop.domain.dto.request.filter;

import com.koksao.shop.domain.products.ClothingSize;
import com.koksao.shop.domain.products.ClothingStyle;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class BaseProductRequest {

    Long id;

    String color;

    String price;

    String material;

    ClothingStyle clothingStyle;

    ClothingSize clothingSize;

}
