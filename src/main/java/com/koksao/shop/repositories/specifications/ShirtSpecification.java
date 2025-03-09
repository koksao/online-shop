package com.koksao.shop.repositories.specifications;

import com.koksao.shop.domain.dto.ShirtFilterRequest;
import com.koksao.shop.domain.products.ClothingSize;
import com.koksao.shop.domain.products.ClothingStyle;
import com.koksao.shop.domain.products.Shirt;
import com.koksao.shop.domain.products.SleeveLength;
import jakarta.persistence.criteria.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class ShirtSpecification {

    public Specification<Shirt> byColor(String color) {
        return (root, query, cb) ->
                cb.equal(
                        root.get("color"),
                        color
                );
    }

    public Specification<Shirt> byPrice(String price) {
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

    public Specification<Shirt> byMaterial(String material) {
        return (root, query, cb) ->
                cb.equal(
                        root.get("material"),
                        material
                );
    }

    public Specification<Shirt> byClothingSize(ClothingSize clothingSize) {
        return (root, query, cb) ->
                cb.equal(
                        root.get("clothingSize"),
                        clothingSize
                );
    }

    public Specification<Shirt> byClothingStyle(ClothingStyle clothingStyle) {
        return (root, query, cb) ->
                cb.equal(
                        root.get("clothingStyle"),
                        clothingStyle
                );
    }

    public Specification<Shirt> bySleeveLength(SleeveLength sleeveLength) {
        return (root, query, cb) ->
                cb.equal(
                        root.get("sleeveLength"),
                        sleeveLength
                );
    }

    public Specification<Shirt> conditionalSearchForShirts(ShirtFilterRequest shirtFilterRequest) {

        Specification<Shirt> spec = Specification.where(null);

        if (shirtFilterRequest.getColor() != null) {
            spec = spec.and(byColor(shirtFilterRequest.getColor()));
        }
        if (shirtFilterRequest.getMaterial() != null) {
            spec = spec.and(byMaterial(shirtFilterRequest.getMaterial()));
        }
        if (shirtFilterRequest.getPrice() != null) {
            spec = spec.and(byPrice(shirtFilterRequest.getPrice()));
        }
        if (shirtFilterRequest.getClothingSize() != null) {
            spec = spec.and(byClothingSize(shirtFilterRequest.getClothingSize()));
        }
        if (shirtFilterRequest.getClothingStyle() != null) {
            spec = spec.and(byClothingStyle(shirtFilterRequest.getClothingStyle()));
        }
        if (shirtFilterRequest.getSleeveLength() != null) {
            spec = spec.and(bySleeveLength(shirtFilterRequest.getSleeveLength()));
        }
        return spec;
    }
}
