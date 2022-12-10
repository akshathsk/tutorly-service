package com.uiuc.fp.service;

import com.uiuc.fp.domain.Topic;
import com.uiuc.fp.domain.User;
import com.uiuc.fp.exception.ValidationException;
import com.uiuc.fp.repository.TopicRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TopicService {

  TopicRepository topicRepository;

  public TopicService(@Lazy TopicRepository topicRepository) {
    this.topicRepository = topicRepository;
  }

  public void updateOverallRating(Double overallRating, Long topicId) {

    Optional<Topic> topicOpt = topicRepository.findById(topicId);
    if (!topicOpt.isPresent()) {
      throw new ValidationException("Unable to update overall rating.");
    }
    Topic topic = topicOpt.get();
    topic.setOverallRating(overallRating);
    topicRepository.save(topic);

  }

  public Object getTopic(Long id) {
    return topicRepository.findById(id).get();
  }

  public Object getTopicByUser(Long userId) {
    User user = new User();
    user.setUserId(userId);
    return topicRepository.findAllByUserIs(user);
  }
}
