package com.belhard.bookstoreBoot.data.mapper;

import com.belhard.bookstoreBoot.data.dto.BookDto;
import com.belhard.bookstoreBoot.data.dto.OrderDto;
import com.belhard.bookstoreBoot.data.dto.OrderInfoDto;
import com.belhard.bookstoreBoot.data.dto.UserDto;
import com.belhard.bookstoreBoot.data.entity.Book;
import com.belhard.bookstoreBoot.data.entity.Order;
import com.belhard.bookstoreBoot.data.entity.OrderInfo;
import com.belhard.bookstoreBoot.data.entity.User;


public interface DataMapper {
    BookDto toDto(Book entity);

    UserDto toDto(User entity);

    OrderDto toDto(Order entity);

    OrderInfoDto toDto(OrderInfo entity);

    Book toEntity(BookDto dto);

    User toEntity(UserDto dto);

    Order toEntity(OrderDto dto);

    OrderInfo toEntity(OrderInfoDto dto);

}
