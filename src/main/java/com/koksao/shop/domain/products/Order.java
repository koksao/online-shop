package com.koksao.shop.domain.products;

import com.koksao.shop.domain.Customer;
import jakarta.persistence.*;
import lombok.*;
import lombok.Getter;
import lombok.Data;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Getter
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    public List<OrderItems> products = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "order_date")
    private LocalDate orderDate;

}
