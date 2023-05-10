package com.belhard.bookstoreBoot.web.controller;

import com.belhard.bookstoreBoot.service.UserService;
import com.belhard.bookstoreBoot.service.dto.UserDto;
import com.belhard.bookstoreBoot.web.exeption.AppException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller("user")
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;


    @GetMapping ("/{id}")
    public String getById(@PathVariable Long id, Model model) throws AppException {
        UserDto user = userService.getById(id);
        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping("/getAll")
    public String getAll (Model model, @RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size){
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        page = page == null ? 0 : page;
        size = size == null ? 5 : size;
        PageRequest pageable = PageRequest.of(page, size, sort);
        Page<UserDto> users = userService.getAll(pageable);
        model.addAttribute("users", users);
        model.addAttribute("current", users.getNumber());
        model.addAttribute("total", users.getTotalPages());
        model.addAttribute("size", users.getSize());
        return "users";
    }

    @GetMapping("/create")
    public String createUserForm(){
        return "userAddForm";
    }


    @PostMapping("/create")
    public String createUser(@ModelAttribute UserDto user){
        userService.create(user);
        return "finishReg";
    }

    @GetMapping("/update/{id}")
    public String updateUserForm(@PathVariable Long id, Model model) throws AppException{
        UserDto user = userService.getById(id);
        model.addAttribute("user",user);
        return "userUpdateForm";
    }


    @PostMapping("/update/{id}")
    public String updateUser(@ModelAttribute UserDto user){
        userService.update(user);
        return "user";
    }


    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        userService.delete(id);
        return "deleteMessage";
    }






}
