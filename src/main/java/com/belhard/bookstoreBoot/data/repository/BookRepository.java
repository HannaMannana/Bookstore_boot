package com.belhard.bookstoreBoot.data.repository;

import com.belhard.bookstoreBoot.data.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}

