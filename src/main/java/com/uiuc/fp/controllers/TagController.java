package com.uiuc.fp.controllers;

import com.uiuc.fp.service.TagService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TagController {

  private final TagService tagService;

  public TagController(TagService tagService) {
    this.tagService = tagService;
  }

  @GetMapping("/v2/tags")
  Object getTags() {
    return tagService.getAllTags();
  }
}
