package com.uiuc.fp.repositories;

import com.uiuc.fp.domain.Tag;
import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag, Long> {
}
