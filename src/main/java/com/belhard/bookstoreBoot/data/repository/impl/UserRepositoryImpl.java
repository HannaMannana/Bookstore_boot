package com.belhard.bookstoreBoot.data.repository.impl;


import com.belhard.bookstoreBoot.data.entity.User;
import com.belhard.bookstoreBoot.data.repository.UserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {
    private static final String FIND_ALL = "from User";

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Optional<User> findById(Long id) {

        return Optional.ofNullable(manager.find(User.class,id));
    }

    @Override
    public List<User> findAll() {

        return manager.createQuery(FIND_ALL, User.class).getResultList();
    }

    @Override
    public Optional <User> save(User entity) {
        manager.persist(entity);
        return Optional.ofNullable(entity);
    }

    @Override
    public Optional <User> update(User entity) {
        return Optional.ofNullable(manager.merge(entity));
    }

    @Override
    public boolean delete(Long id) {
        User entity = manager.find(User.class, id);
        if (entity != null){
            manager.remove(entity);
            return true;
        }
        return false;
    }

}
