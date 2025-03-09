package com.koksao.shop.services.impl;

import com.koksao.shop.domain.products.Pants;
import com.koksao.shop.repositories.products.PantsRepository;
import com.koksao.shop.services.PantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PantsServiceImpl implements PantsService {

    @Autowired
    private PantsRepository pantsRepository;

    @Override
    public Pants save(Pants pants) {
        return pantsRepository.save(pants);
    }

    @Override
    public List<Pants> findAll() {
        return StreamSupport.stream(pantsRepository
                                .findAll()
                                .spliterator(),
                        false)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Pants> findById(Long id) {
        return pantsRepository.findById(id);
    }

}
