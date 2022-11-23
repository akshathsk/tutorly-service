package com.uiuc.fp.repositories;

import com.uiuc.fp.domain.Topic;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TopicRepository extends PagingAndSortingRepository<Topic, Long> {
}
