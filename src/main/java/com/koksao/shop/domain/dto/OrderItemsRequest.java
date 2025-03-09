package com.koksao.shop.domain.dto;


import lombok.Data;
import java.time.LocalDate;

@Data
public class OrderItemsRequest {

    private Long customer_id;

    private LocalDate orderDate;

    private Long product_id;

    private int quantity;
}
