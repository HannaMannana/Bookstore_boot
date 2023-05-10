package com.belhard.bookstoreBoot.service.impl;

import com.belhard.bookstoreBoot.data.entity.User;
import com.belhard.bookstoreBoot.data.repository.UserRepository;
import com.belhard.bookstoreBoot.service.UserService;
import com.belhard.bookstoreBoot.service.dto.UserDto;
import com.belhard.bookstoreBoot.web.exeption.AppException;
import com.belhard.bookstoreBoot.web.exeption.BadRequestException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    private UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setRoleType(user.getRoleType());
        return userDto;
    }

    private User toEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRoleType(userDto.getRoleType());
        return user;
    }


    @Override
    public UserDto getById(Long id) throws AppException {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.orElseThrow(()->new AppException("None user with id" + id));
        log.debug("Get by id: id ={}",id);
        return toDto(user);
    }

    @Override
    public List<UserDto> getAll() {
        log.debug("Find all users");
        List<UserDto> dtos = userRepository.findAll().stream().map(this::toDto).toList();
        return dtos;
    }

    @Override
    public UserDto create(UserDto dto) {

        dto.setRoleType(User.Role.CUSTOMER);

        log.debug("create: new UserDto ={}",dto);
        if (dto.getName() == null || dto.getName().isBlank()) {
            throw new BadRequestException("Name is required");
        }
        if (dto.getLastName() == null || dto.getLastName().isBlank()) {
            throw new BadRequestException("LastName is required");
        }
        if (dto.getEmail() == null || dto.getEmail().isBlank()) {
            throw new BadRequestException("Email is required");
        }
        if (dto.getPassword() == null || dto.getPassword().isBlank()) {
            throw new BadRequestException("Password is required");
        } else {
            User user = userRepository.save(toEntity(dto));
            return toDto(user);
        }
    }


    @Override
    public UserDto update(UserDto dto) {
        User user = userRepository.save(toEntity(dto));
        log.debug("update id ={}", dto.getId());
        return toDto(user);
    }

    @Override
    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("No user with id:" + id);
        }
        userRepository.deleteById(id);
    }


    @Override
    public UserDto login(String email, String password) throws AccountNotFoundException {
        Optional <User> userOpt = userRepository.findByEmail(email);
        User user = userOpt.orElseThrow(() -> new RuntimeException("Id is required"));
        if (!password.equals(user.getPassword())){
            log.error("None user with password: {}", password);
            throw new RuntimeException();
        }
        log.debug("Try get login by email and password:{}",email,password);
       return toDto(user);
    }

}

