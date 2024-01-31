package com.twetero.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.twetero.api.dtos.TweetDTO;
import com.twetero.api.models.TweetModel;
import com.twetero.api.models.UserModel;
import com.twetero.api.repositories.TweetRepository;
import com.twetero.api.repositories.UserRepository;

@Service
public class TweetService {

  final TweetRepository tweetRepository;
  final UserRepository userRepository;

  TweetService(TweetRepository tweetRepository, UserRepository userRepository) {
    this.tweetRepository = tweetRepository;
    this.userRepository = userRepository;
  }

  public List<TweetModel> findAll() {
    return tweetRepository.findAll();
  }

  public Optional<List<TweetModel>> findAllByUserId(Long userId) {
    Optional<UserModel> user = userRepository.findById((userId));
    if (!user.isPresent()) {
      return Optional.empty();
    }
    return Optional.of(tweetRepository.findAllByUserId(userId));
  }

  public Optional<TweetModel> save(TweetDTO dto) {
    Optional<UserModel> user = userRepository.findById((dto.getUserId()));

    if (!user.isPresent()) {
      return Optional.empty();
    }

    TweetModel tweet = new TweetModel(dto, user.get());
    return Optional.of(tweetRepository.save(tweet));
  }
}
