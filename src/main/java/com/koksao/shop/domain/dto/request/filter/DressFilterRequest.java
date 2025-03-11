package com.koksao.shop.domain.dto.request.filter;

import com.koksao.shop.domain.products.DressLength;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class DressFilterRequest extends BaseProductRequest {

    DressLength dressLength;
}
