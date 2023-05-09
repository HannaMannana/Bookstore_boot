package com.belhard.bookstoreBoot.data.repository;

import com.belhard.bookstoreBoot.data.entity.Order;

import java.util.Optional;

public interface OrderRepository extends CrudRepository<Long, Order>{
    Optional<Order> create(Order entity);
}
