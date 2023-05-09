package com.belhard.bookstoreBoot.data.repository.impl;

import com.belhard.bookstoreBoot.data.entity.Order;
import com.belhard.bookstoreBoot.data.repository.OrderRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class OrderRepositoryImpl implements OrderRepository {
    private static final String FIND_ALL = "from Order";
    private Order order;

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Optional<Order> findById(Long id) {
        return Optional.ofNullable(manager.find(Order.class, id));

    }

    @Override
    public List<Order> findAll() {
        return manager.createQuery(FIND_ALL, Order.class).getResultList();
    }


    public Optional<Order> create(Order entity) {
        if (entity.getId() == null) {
            manager.persist(entity);
            order = entity;
        } else {
            manager.merge(entity);
        }
        return Optional.of(entity);
    }

    @Override
    public Optional<Order> save(Order entity) {
        manager.persist(entity);
        return Optional.ofNullable(entity);
    }

    @Override
    public Optional<Order> update(Order entity) {
        return Optional.ofNullable(manager.merge(entity));
    }

    @Override
    public boolean delete(Long id) {
        Order entity = manager.find(Order.class, id);
        if (entity != null) {
            manager.remove(entity);
            return true;
        }
        return false;
    }


}
