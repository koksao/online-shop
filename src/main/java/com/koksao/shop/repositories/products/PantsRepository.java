package com.koksao.shop.repositories.products;

import com.koksao.shop.domain.products.Pants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PantsRepository extends JpaRepository<Pants, Long>, JpaSpecificationExecutor<Pants> {
}
