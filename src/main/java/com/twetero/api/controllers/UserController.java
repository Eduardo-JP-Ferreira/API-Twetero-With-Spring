package com.twetero.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twetero.api.models.UserModel;
import com.twetero.api.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

    final UserRepository userRepository;

    UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<UserModel> getHolidays() {
        return userRepository.findAll();
    }
}
