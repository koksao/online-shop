package com.koksao.shop.repositories.products;

import com.koksao.shop.domain.products.Jacket;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JacketRepository extends JpaRepository<Jacket, Long>, JpaSpecificationExecutor<Jacket> {

    List<Jacket> findAll(Specification<Jacket> specification);
}
