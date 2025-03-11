package com.koksao.shop.services;

import com.koksao.shop.domain.dto.request.filter.DressFilterRequest;
import com.koksao.shop.domain.products.Dress;

import java.util.List;
import java.util.Optional;

public interface DressService {

    Dress save(Dress dress);

    List<Dress> findAll();

    Optional<Dress> findById(Long id);

    List<Dress> findAll(DressFilterRequest dressFilterRequest);

}
