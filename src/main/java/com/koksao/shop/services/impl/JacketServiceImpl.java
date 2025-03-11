package com.koksao.shop.services.impl;

import com.koksao.shop.domain.dto.request.filter.JacketFilterRequest;
import com.koksao.shop.domain.products.Jacket;
import com.koksao.shop.repositories.products.JacketRepository;
import com.koksao.shop.repositories.specifications.JacketSpecification;
import com.koksao.shop.services.JacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class JacketServiceImpl implements JacketService {

    @Autowired
    JacketRepository jacketRepository;

    @Autowired
    JacketSpecification jacketSpecification;

    @Override
    public Jacket save(Jacket jacket) {
        return jacketRepository.save(jacket);
    }

    @Override
    public List<Jacket> findAll() {
        return StreamSupport.stream(jacketRepository
                                .findAll()
                                .spliterator(),
                        false)
                .toList();
    }

    @Override
    public Optional<Jacket> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Jacket> findAll(JacketFilterRequest jacketFilterRequest) {
        List<Jacket> jackets = jacketRepository.findAll(jacketSpecification.conditionalSearchForJacket(jacketFilterRequest));
        return jackets;
    }
}
