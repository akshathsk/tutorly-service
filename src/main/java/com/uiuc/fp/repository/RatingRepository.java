package com.uiuc.fp.repository;

import com.uiuc.fp.domain.Rating;
import com.uiuc.fp.domain.Topic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RatingRepository extends CrudRepository<Rating, Long> {

  List<Rating> findAllByTopicIs(Topic topic);
}
