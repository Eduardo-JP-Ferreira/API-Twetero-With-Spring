package com.twetero.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.twetero.api.dtos.TweetDTO;
import com.twetero.api.models.TweetModel;
import com.twetero.api.repositories.TweetRepository;

@Service
public class TweetService {

  final TweetRepository tweetRepository;

  TweetService(TweetRepository tweetRepository) {
    this.tweetRepository = tweetRepository;
  }

  public List<TweetModel> findAll() {
    return tweetRepository.findAll();
  }

  public Optional<TweetModel> save(TweetDTO dto) {
    TweetModel tweet = new TweetModel(dto);
    return Optional.of(tweetRepository.save(tweet));
  }
}
