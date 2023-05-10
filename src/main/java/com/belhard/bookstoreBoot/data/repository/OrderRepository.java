package com.belhard.bookstoreBoot.data.repository;

import com.belhard.bookstoreBoot.data.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
