package com.koksao.shop.repositories.specifications;

import com.koksao.shop.domain.dto.request.filter.JacketFilterRequest;
import com.koksao.shop.domain.products.Jacket;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class JacketSpecification extends BaseProductSpecification<Jacket> {

    public Specification<Jacket> conditionalSearchForJacket(JacketFilterRequest jacketFilterRequest) {
        return conditionalSearchForBaseProduct(jacketFilterRequest);
    }
}
