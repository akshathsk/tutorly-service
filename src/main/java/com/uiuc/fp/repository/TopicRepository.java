package com.uiuc.fp.repository;

import com.uiuc.fp.domain.Topic;
import com.uiuc.fp.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TopicRepository extends CrudRepository<Topic, Long> {

  List<Topic> findAllByUserIs(User user);
  @Query(value = "select * from topic where user_id = ?" , nativeQuery = true)
  List<Topic> findByUserId(String userId);

}
