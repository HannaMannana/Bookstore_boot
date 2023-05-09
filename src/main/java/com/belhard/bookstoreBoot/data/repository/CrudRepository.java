package com.belhard.bookstoreBoot.data.repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository <K, T>{
    Optional<T> findById(K id);
    List<T> findAll();
    Optional<T> save(T entity);
    Optional<T> update (T entity);
    boolean delete (K id);
}
