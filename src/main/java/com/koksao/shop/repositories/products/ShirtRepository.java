package com.koksao.shop.repositories.products;

import com.koksao.shop.domain.products.Shirt;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ShirtRepository extends JpaRepository<Shirt, Long>, JpaSpecificationExecutor<Shirt> {

    List<Shirt> findAll(Specification<Shirt> specification);

}
