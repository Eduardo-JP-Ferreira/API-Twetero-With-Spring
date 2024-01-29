package com.twetero.api.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twetero.api.dtos.UserDTO;
import com.twetero.api.models.UserModel;
import com.twetero.api.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

  final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public ResponseEntity<Object> getHolidays() {
    return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
  }

  @PostMapping
  public ResponseEntity<Object> createUser(@RequestBody @Valid UserDTO body) {
    Optional<UserModel> user = userService.save(body);
    if (!user.isPresent()) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body("This Username Already Exist");
    }
    return ResponseEntity.status(HttpStatus.CREATED).body(user);
  }
}
