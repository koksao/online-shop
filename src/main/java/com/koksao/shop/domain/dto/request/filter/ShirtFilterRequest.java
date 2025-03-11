package com.koksao.shop.domain.dto.request.filter;

import com.koksao.shop.domain.products.SleeveLength;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ShirtFilterRequest extends BaseProductRequest {

    SleeveLength sleeveLength;

}
