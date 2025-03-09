package com.koksao.shop.domain.dto;

import com.koksao.shop.domain.products.ClothingSize;
import com.koksao.shop.domain.products.ClothingStyle;
import com.koksao.shop.domain.products.SleeveLength;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ShirtFilterRequest {

    String color;

    String material;

    String price;

    ClothingSize clothingSize;

    ClothingStyle clothingStyle;

    SleeveLength sleeveLength;

}
