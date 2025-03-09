package com.koksao.shop.services;

import com.koksao.shop.domain.Customer;

import java.util.List;
import java.util.Optional;


public interface CustomerService {

    Customer save(Customer customer);

    List<Customer> findAll();

    Optional<Customer> findById(Long id);

    Optional<Customer> findByName(String firstName, String lastName);

}
