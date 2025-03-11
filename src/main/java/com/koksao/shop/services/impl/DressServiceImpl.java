package com.koksao.shop.services.impl;

import com.koksao.shop.domain.dto.request.filter.DressFilterRequest;
import com.koksao.shop.domain.products.Dress;
import com.koksao.shop.repositories.products.DressRepository;
import com.koksao.shop.repositories.specifications.DressSpecification;
import com.koksao.shop.services.DressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class DressServiceImpl implements DressService {

    @Autowired
    DressRepository dressRepository;

    @Autowired
    DressSpecification dressSpecification;

    @Override
    public Dress save(Dress dress) {
        return dressRepository.save(dress);
    }

    @Override
    public List<Dress> findAll() {
        return StreamSupport.stream(dressRepository
                                .findAll()
                                .spliterator(),
                        false)
                .toList();
    }

    @Override
    public Optional<Dress> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Dress> findAll(DressFilterRequest dressFilterRequest) {
        List<Dress> dresses = dressRepository.findAll(dressSpecification.conditionalSearchForDress(dressFilterRequest));
        return dresses;
    }
}
