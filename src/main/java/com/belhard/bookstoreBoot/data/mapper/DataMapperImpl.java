package com.belhard.bookstoreBoot.data.mapper;

import com.belhard.bookstoreBoot.data.dto.BookDto;
import com.belhard.bookstoreBoot.data.dto.OrderDto;
import com.belhard.bookstoreBoot.data.dto.OrderInfoDto;
import com.belhard.bookstoreBoot.data.dto.UserDto;
import com.belhard.bookstoreBoot.data.entity.Book;
import com.belhard.bookstoreBoot.data.entity.Order;
import com.belhard.bookstoreBoot.data.entity.OrderInfo;
import com.belhard.bookstoreBoot.data.entity.User;
import org.springframework.stereotype.Component;

@Component
public class DataMapperImpl implements DataMapper{

    @Override
    public BookDto toDto(Book entity) {
        BookDto dto = new BookDto();
        dto.setId(entity.getId());
        dto.setBookName(entity.getBookName());
        dto.setPrice(entity.getPrice());
        dto.setIsbn(entity.getIsbn());
        dto.setCoverType(entity.getCoverType());
        dto.setAuthor(entity.getAuthor());
        dto.setNumberOfPages(entity.getNumberOfPages());
        dto.setYearOfPublication(entity.getYearOfPublication());
        return dto;
    }


    @Override
    public UserDto toDto(User entity) {
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());
        User.Role roleType = entity.getRoleType();

        if(roleType !=null) {
            dto.setRoleType(UserDto.Role.valueOf(roleType.toString()));
        }
        return dto;
    }

    @Override
    public OrderDto toDto(Order entity) {
        OrderDto dto = new OrderDto();
        dto.setId(entity.getId());
        User user = entity.getUser();
        if (user != null){
            dto.setUserId(user.getId());
        }
        dto.setTotalCost(entity.getTotalCost());
        Order.Status status = entity.getStatus();
        if(status != null){
            dto.setStatus(OrderDto.Status.valueOf(status.toString()));
        }
        return dto;
    }

    @Override
    public OrderInfoDto toDto(OrderInfo entity) {
        OrderInfoDto dto = new OrderInfoDto();
        dto.setId(entity.getId());
        Book book = entity.getBook();
        if(book !=null){
            dto.setBookId(book.getId());
        }
        dto.setBookPrice(entity.getBookPrice());
        dto.setBookQuantity(entity.getBookQuantity());
        dto.setOrderId(entity.getOrderId());
        return dto;
    }

    @Override
    public Book toEntity(BookDto dto) {
        Book entity = new Book();
        entity.setId(dto.getId());
        entity.setBookName(dto.getBookName());
        entity.setPrice(dto.getPrice());
        entity.setAuthor(dto.getAuthor());
        entity.setIsbn(dto.getIsbn());
        entity.setNumberOfPages(dto.getNumberOfPages());
        entity.setYearOfPublication(dto.getYearOfPublication());
        entity.setCoverType(dto.getCoverType());
        return entity;
    }

    @Override
    public User toEntity(UserDto dto) {
        User entity = new User();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        UserDto.Role roleType = dto.getRoleType();

        if(roleType !=null) {
            entity.setRoleType(User.Role.valueOf(roleType.toString()));
        }
        return entity;
    }

    @Override
    public Order toEntity(OrderDto dto) {
        Order entity = new Order();
        entity.setId(dto.getId());
        entity.setTotalCost(dto.getTotalCost());
        User user = entity.getUser();
        if(user != null) {
            dto.setUserId(user.getId());
        }
        OrderDto.Status status = dto.getStatus();
        if(status != null){
            entity.setStatus(Order.Status.valueOf(status.toString()));
        }
        return entity;
    }



    @Override
    public OrderInfo toEntity(OrderInfoDto dto) {
        OrderInfo entity = new OrderInfo();
        entity.setId(dto.getId());
        Book book = entity.getBook();
        if(book !=null){
            dto.setBookId(book.getId());
        }
        entity.setBookPrice(dto.getBookPrice());
        entity.setBookQuantity(dto.getBookQuantity());
        entity.setOrderId(dto.getOrderId());
        return entity;
    }

}
