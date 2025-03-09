package com.koksao.shop.domain.products;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String color;

    @NotNull
    @Min(value = 1)
    private Double price;

    private String material;

    @Enumerated(EnumType.STRING)
    private ClothingStyle clothingStyle;

    @Enumerated(EnumType.STRING)
    private ClothingSize clothingSize;

    @NotNull
    @Min(value = 0)
    private int availability;

    public boolean reduceAvailability(int quantity) {
        if (quantity <= availability) {
            this.availability -= quantity;
            return true;
        } else {
            return false;
        }
    }

}
