package com.koksao.shop.repositories.specifications;

import com.koksao.shop.domain.dto.request.filter.ShirtFilterRequest;
import com.koksao.shop.domain.products.Shirt;
import com.koksao.shop.domain.products.SleeveLength;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class ShirtSpecification extends BaseProductSpecification<Shirt> {


    public Specification<Shirt> bySleeveLength(SleeveLength sleeveLength) {
        return (root, query, cb) ->
                cb.equal(
                        root.get("sleeveLength"),
                        sleeveLength
                );
    }

    public Specification<Shirt> conditionalSearchForShirts(ShirtFilterRequest shirtFilterRequest) {

        Specification<Shirt> spec = conditionalSearchForBaseProduct(shirtFilterRequest);

        if (shirtFilterRequest.getSleeveLength() != null) {
            spec = spec.and(bySleeveLength(shirtFilterRequest.getSleeveLength()));
        }
        return spec;
    }
}
