package com.uiuc.fp.repository;

import com.uiuc.fp.domain.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, Long> {
}
