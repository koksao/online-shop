package com.koksao.shop.repositories;

import com.koksao.shop.domain.products.OrderItems;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItems, Long> {
}
