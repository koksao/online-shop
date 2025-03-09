package com.koksao.shop.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee extends Person {

    @Column(name = "date_of_employment")
    @NotNull
    private LocalDate dateOfEmployment;

    @NotNull
    @Min(value = 0)
    private Integer salary;

    @NotNull
    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private Position position;

}
