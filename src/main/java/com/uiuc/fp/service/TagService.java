package com.uiuc.fp.service;

import com.uiuc.fp.repository.TagRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class TagService {

  private final TagRepository tagRepository;

  public TagService(@Lazy TagRepository tagRepository) {
    this.tagRepository = tagRepository;
  }

  public Object getAllTags() {
    return tagRepository.findAll();
  }
}
