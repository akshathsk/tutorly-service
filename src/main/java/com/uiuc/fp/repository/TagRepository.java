package com.uiuc.fp.repository;

import com.uiuc.fp.domain.Tag;
import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag, Long> {
}
