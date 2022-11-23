package com.uiuc.fp.repositories;

import com.uiuc.fp.domain.Rating;
import org.springframework.data.repository.CrudRepository;

public interface RatingRepository extends CrudRepository<Rating, Long> {
}
