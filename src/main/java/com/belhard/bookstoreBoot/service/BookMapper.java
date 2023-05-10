package com.belhard.bookstoreBoot.service;

import com.belhard.bookstoreBoot.data.entity.Book;
import com.belhard.bookstoreBoot.service.dto.BookDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDto toDto(Book entity);

    Book toEntity(BookDto dto);
}
