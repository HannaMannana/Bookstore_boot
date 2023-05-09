package com.belhard.bookstoreBoot.data.repository;

import com.belhard.bookstoreBoot.data.entity.Book;

import javax.persistence.Query;

public interface BookRepository extends CrudRepository<Long, Book>{
    Query count();
}

