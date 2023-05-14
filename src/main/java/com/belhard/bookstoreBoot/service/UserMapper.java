package com.belhard.bookstoreBoot.service;


import com.belhard.bookstoreBoot.data.entity.User;
import com.belhard.bookstoreBoot.service.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User entity);
    User toEntity(UserDto dto);
}
