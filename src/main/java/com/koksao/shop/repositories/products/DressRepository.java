package com.koksao.shop.repositories.products;

import com.koksao.shop.domain.products.Dress;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DressRepository extends JpaRepository<Dress, Long>, JpaSpecificationExecutor<Dress> {

    List<Dress> findAll(Specification<Dress> specification);
}
