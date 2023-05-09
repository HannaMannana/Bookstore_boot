package com.belhard.bookstoreBoot.data.repository.impl;

import com.belhard.bookstoreBoot.data.entity.Book;
import com.belhard.bookstoreBoot.data.repository.BookRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class BookRepositoryImpl implements BookRepository {
    private static final String FIND_ALL = "from Book";

    @PersistenceContext
    private EntityManager manager;


    @Override
    public Optional<Book> findById(Long id) {

        return Optional.ofNullable(manager.find(Book.class, id));
    }

    @Override
    public List<Book> findAll() {
        return manager.createQuery(FIND_ALL, Book.class).getResultList();
    }

    @Override
    public Optional<Book> save(Book entity) {
          manager.persist(entity);
          return Optional.ofNullable(entity);
    }



    @Override
    public Optional<Book> update(Book entity) {
        return Optional.ofNullable(manager.merge(entity));
    }

    @Override
    public boolean delete(Long id) {
        Book entity = manager.find(Book.class, id);
        if (entity != null){
            manager.remove(entity);
            return true;
        }
        return false;
    }

    @Override
    public Query count() {
        return manager.createQuery("count(*) FROM bookstore_bh");
    }
}