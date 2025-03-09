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
@Table(name = "pants")
public class Pants extends Product {

    @Column(name = "pants_length")
    @Enumerated(EnumType.STRING)
    private PantsLength pantsLength;
}
