package com.koksao.shop.domain.products;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "shirt")
@Entity
public class Shirt extends Product {

    @Column(name = "sleeve_length")
    @Enumerated(EnumType.STRING)
    private SleeveLength sleeveLength;

}
