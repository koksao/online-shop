package com.koksao.shop.repositories.specifications;

import com.koksao.shop.domain.dto.request.filter.DressFilterRequest;
import com.koksao.shop.domain.products.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class DressSpecification extends BaseProductSpecification<Dress> {

    public Specification<Dress> byDressLength(DressLength dressLength) {

        return (root, query, cb) ->
                cb.equal(root.get("dressLength"),
                        dressLength
                );
    }

    public Specification<Dress> conditionalSearchForDress(DressFilterRequest dressFilterRequest) {

        Specification<Dress> spec = conditionalSearchForBaseProduct(dressFilterRequest);

        if (dressFilterRequest.getDressLength() != null) {
            spec = spec.and(byDressLength(dressFilterRequest.getDressLength()));
        }
        return spec;
    }

}
