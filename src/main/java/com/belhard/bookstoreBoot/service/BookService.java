package com.belhard.bookstoreBoot.service;

import com.belhard.bookstoreBoot.service.dto.BookDto;
import com.belhard.bookstoreBoot.web.exeption.AppException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {

    BookDto getById(Long id) throws AppException;

    Page<BookDto> getAll(Pageable pageable);

    BookDto create(BookDto dto);

    BookDto update( BookDto dto);

    void delete(Long id);
}
