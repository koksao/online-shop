package com.koksao.shop.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @NotBlank
    private String city;

    @NotBlank
    private String street;

    @Column(name = "postal_code")
    @NotBlank
    private String postalCode;

    @NotBlank
    private String country;

    @Column(name = "building_number")
    @NotNull
    @Min(value = 1)
    private Integer buildingNumber;

    @Column(name = "apartment_number")
    @NotNull
    @Min(value = 1)
    private Integer apartmentNumber;
}
