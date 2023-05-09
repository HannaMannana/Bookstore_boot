package com.belhard.bookstoreBoot.service;

import com.belhard.bookstoreBoot.service.dto.BookDto;
import com.belhard.bookstoreBoot.web.exeption.AppException;

import java.util.List;

public interface BookService {

    BookDto getById(Long id) throws AppException;

    List<BookDto> getAll();

    BookDto create(BookDto dto);

    BookDto update( BookDto dto);

    boolean delete(Long id);
}
