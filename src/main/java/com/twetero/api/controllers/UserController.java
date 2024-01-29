package com.twetero.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<Object> getHolidays() {
    List<UserModel> users = userRepository.findAll();
    return ResponseEntity.status(HttpStatus.OK).body(users);
  }

  @PostMapping
  public ResponseEntity<Object> createUser(@RequestBody @Valid UserDTO body) {
    UserModel user = new UserModel(body);
    userRepository.save(user);
    return ResponseEntity.status(HttpStatus.CREATED).body(user);
  }
}
