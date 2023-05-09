package com.belhard.bookstoreBoot.service;

import com.belhard.bookstoreBoot.service.dto.UserDto;
import com.belhard.bookstoreBoot.web.exeption.AppException;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

public interface UserService {

    UserDto getById(Long id) throws AppException;

    List<UserDto> getAll();

    UserDto create(UserDto dto);

    UserDto update( UserDto dto);

    boolean delete(Long id);

    UserDto login (String email, String password) throws AccountNotFoundException;
}
