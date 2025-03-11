package com.koksao.shop.services;

import com.koksao.shop.domain.dto.request.filter.ShirtFilterRequest;
import com.koksao.shop.domain.products.Shirt;

import java.util.List;
import java.util.Optional;

public interface ShirtService {

    Shirt save(Shirt shirt);

    List<Shirt> findAll();

    Optional<Shirt> findById(Long id);

    List<Shirt> findAll(ShirtFilterRequest shirtFilterRequest);

}
