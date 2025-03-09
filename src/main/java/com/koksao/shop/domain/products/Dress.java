package com.koksao.shop.domain.products;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "dress")
public class Dress extends Product {

    @Column(name = "dress_length")
    @Enumerated(EnumType.STRING)
    private DressLength dressLength;

}
