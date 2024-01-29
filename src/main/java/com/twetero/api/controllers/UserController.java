package com.twetero.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twetero.api.dtos.UserDTO;
import com.twetero.api.models.UserModel;
import com.twetero.api.repositories.UserRepository;

import jakarta.validation.Valid;

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

  @PostMapping
  public void createUser(@RequestBody @Valid UserDTO body) {
    UserModel user = new UserModel(body);
    userRepository.save(user);
  }
}
