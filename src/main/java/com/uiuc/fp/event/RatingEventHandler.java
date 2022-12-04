package com.uiuc.fp.event;

import com.uiuc.fp.domain.Rating;
import com.uiuc.fp.service.RatingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.PostPersist;

@Slf4j
@RequiredArgsConstructor
public class RatingEventHandler {

  private final RatingService ratingService;

  /**
   * Captures all post events on the Rating table
   *
   * @param rating
   */
  @PostPersist
  private void afterInsert(Rating rating) {
    ratingService.updateOverallRating(rating);
  }
}
