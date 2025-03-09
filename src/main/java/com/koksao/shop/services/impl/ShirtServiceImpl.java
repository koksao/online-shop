package com.koksao.shop.services.impl;

import com.koksao.shop.domain.dto.ShirtFilterRequest;
import com.koksao.shop.domain.products.Shirt;
import com.koksao.shop.repositories.products.ShirtRepository;
import com.koksao.shop.repositories.specifications.ShirtSpecification;
import com.koksao.shop.services.ShirtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class ShirtServiceImpl implements ShirtService {

    @Autowired
    ShirtRepository shirtRepository;

    @Autowired
    ShirtSpecification shirtSpecification;

    @Override
    public Shirt save(Shirt shirt) {
        return shirtRepository.save(shirt);
    }

    @Override
    public List<Shirt> findAll() {
        return StreamSupport.stream(shirtRepository
                                .findAll()
                                .spliterator(),
                        false)
                .toList();
    }

    @Override
    public Optional<Shirt> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Shirt> findAll(ShirtFilterRequest shirtFilterRequest) {
        List<Shirt> filteredShirts = shirtRepository.findAll(shirtSpecification
                .conditionalSearchForShirts(shirtFilterRequest));
        return filteredShirts;
    }

}
