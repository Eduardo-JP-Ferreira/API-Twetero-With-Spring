package com.twetero.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twetero.api.dtos.TweetDTO;
import com.twetero.api.models.TweetModel;
import com.twetero.api.services.TweetService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tweets")
public class TweetController {

  final TweetService tweetService;

  public TweetController(TweetService tweetService) {
    this.tweetService = tweetService;
  }

  @GetMapping
  public ResponseEntity<Object> getHolidays() {
    return ResponseEntity.status(HttpStatus.OK).body(tweetService.findAll());
  }

  @GetMapping("/user/{userId}")
  public ResponseEntity<Object> getTweetById(@PathVariable("userId") Long userId) {
    Optional<List<TweetModel>> tweet = tweetService.findAllByUserId(userId);

    if (!tweet.isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
    }

    return ResponseEntity.status(HttpStatus.OK).body(tweet.get());
  }

  @PostMapping
  public ResponseEntity<Object> createTweet(@RequestBody @Valid TweetDTO body) {
    Optional<TweetModel> tweet = tweetService.save(body);
    return ResponseEntity.status(HttpStatus.CREATED).body(tweet);
  }
}
