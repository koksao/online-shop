package com.koksao.shop.repositories.specifications;

import com.koksao.shop.domain.dto.request.filter.BaseProductRequest;
import com.koksao.shop.domain.products.ClothingSize;
import com.koksao.shop.domain.products.ClothingStyle;
import jakarta.persistence.criteria.Order;
import org.springframework.data.jpa.domain.Specification;

public abstract class BaseProductSpecification<T> {

    public Specification<T> byColor(String color) {
        return (root, query, cb) ->
                cb.equal(
                        root.get("color"),
                        color
                );
    }

    public Specification<T> byPrice(String price) {
        return (root, query, cb) -> {
            Order priceOrder;
            if ("desc".equalsIgnoreCase(price)) {
                priceOrder = cb.desc(root.get("price"));
            } else {
                priceOrder = cb.asc(root.get("price"));
            }

            query.orderBy(priceOrder);
            return cb.conjunction();
        };
    }

    public Specification<T> byMaterial(String material) {
        return (root, query, cb) ->
                cb.equal(
                        root.get("material"),
                        material
                );
    }

    public Specification<T> byClothingSize(ClothingSize clothingSize) {
        return (root, query, cb) ->
                cb.equal(
                        root.get("clothingSize"),
                        clothingSize
                );
    }

    public Specification<T> byClothingStyle(ClothingStyle clothingStyle) {
        return (root, query, cb) ->
                cb.equal(
                        root.get("clothingStyle"),
                        clothingStyle
                );
    }

    Specification<T> conditionalSearchForBaseProduct(BaseProductRequest baseProductRequest) {

        Specification<T> spec = Specification.where(null);

        if (baseProductRequest.getColor() != null) {
            spec = spec.and(byColor(baseProductRequest.getColor()));
        }
        if (baseProductRequest.getMaterial() != null) {
            spec = spec.and(byMaterial(baseProductRequest.getMaterial()));
        }
        if (baseProductRequest.getPrice() != null) {
            spec = spec.and(byPrice(baseProductRequest.getPrice()));
        }
        if (baseProductRequest.getClothingSize() != null) {
            spec = spec.and(byClothingSize(baseProductRequest.getClothingSize()));
        }
        if (baseProductRequest.getClothingStyle() != null) {
            spec = spec.and(byClothingStyle(baseProductRequest.getClothingStyle()));
        }
        return spec;
    }

}
