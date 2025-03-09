package com.koksao.shop.repositories.products;

import com.koksao.shop.domain.products.Jacket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface JacketRepository extends JpaRepository<Jacket, Long>, JpaSpecificationExecutor<Jacket> {
}
