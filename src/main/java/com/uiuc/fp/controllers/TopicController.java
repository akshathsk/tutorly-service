package com.uiuc.fp.controllers;

import com.uiuc.fp.service.TopicService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

  private final TopicService topicService;

  public TopicController(TopicService topicService) {
    this.topicService = topicService;
  }


  @GetMapping("/v2/topics/{id}")
  Object getTopic(@PathVariable Long id)
  {
    return topicService.getTopic(id);
  }
}
