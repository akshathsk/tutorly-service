package com.uiuc.fp.service;

import com.uiuc.fp.domain.Tag;
import com.uiuc.fp.domain.TagDto;
import com.uiuc.fp.domain.Topic;
import com.uiuc.fp.repository.TagRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

  private final TagRepository tagRepository;

  public TagService(@Lazy TagRepository tagRepository) {
    this.tagRepository = tagRepository;
  }

  public Object getAllTags() {
    return tagRepository.findAll();
  }

  public Object saveAllTags(TagDto tagDto) {
    List<Tag> tags = (List<Tag>) tagRepository.findAllById(tagDto.getTagIds());
    tags.forEach(tag -> {
      Topic topic = new Topic();
      topic.setTopicId(tagDto.getTopicId());
      tag.getTopics().add(topic);
    });

    return tagRepository.saveAll(tags);
  }
}
