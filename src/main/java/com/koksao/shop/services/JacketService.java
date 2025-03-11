package com.koksao.shop.services;

import com.koksao.shop.domain.dto.request.filter.JacketFilterRequest;
import com.koksao.shop.domain.products.Jacket;

import java.util.List;
import java.util.Optional;

public interface JacketService {

    Jacket save(Jacket jacket);

    List<Jacket> findAll();

    Optional<Jacket> findById(Long id);

    List<Jacket> findAll(JacketFilterRequest jacketFilterRequest);
}
