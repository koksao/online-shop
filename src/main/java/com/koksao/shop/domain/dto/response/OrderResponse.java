package com.koksao.shop.domain.dto.response;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
public class OrderResponse {

    private Long Id;

    private String customer_name;

    private LocalDate orderDate;

    public List<OrderItemsResponse> products;

}
