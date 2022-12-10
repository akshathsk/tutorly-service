package com.uiuc.fp.controllers;

import com.uiuc.fp.domain.TagDto;
import com.uiuc.fp.service.TagService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TagController {

  private final TagService tagService;

  public TagController(TagService tagService) {
    this.tagService = tagService;
  }

  @GetMapping("/v2/tags")
  Object getTags() {
    return tagService.getAllTags();
  }

  @PostMapping(path = "/v2/tags")
  public Object create(@RequestBody TagDto tagDto) {
      return tagService.saveAllTags(tagDto);
  }
}
