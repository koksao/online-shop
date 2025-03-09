package com.koksao.shop.services;

import com.koksao.shop.domain.products.Pants;

import java.util.List;
import java.util.Optional;


public interface PantsService {

    Pants save(Pants pants);

    List<Pants> findAll();

    Optional<Pants> findById(Long id);
}
