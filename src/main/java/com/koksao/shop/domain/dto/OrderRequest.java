package com.koksao.shop.domain.dto;

import lombok.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class OrderRequest {

    private Long customer_id;

    private LocalDate orderDate;

    public List<OrderItemsRequest> products = new ArrayList<>();

}
