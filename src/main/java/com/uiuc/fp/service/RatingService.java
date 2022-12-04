package com.uiuc.fp.service;

import com.uiuc.fp.domain.Rating;
import com.uiuc.fp.repository.RatingRepository;
import com.uiuc.fp.util.UtilHelper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RatingService {

  private final TopicService topicService;

  private final RatingRepository ratingRepository;

  public RatingService(@Lazy TopicService topicService, @Lazy RatingRepository ratingRepository) {
    this.topicService = topicService;
    this.ratingRepository = ratingRepository;
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void updateOverallRating(Rating rating) {

    List<Rating> ratingList = ratingRepository.findAllByTopicIs(rating.getTopic());
    Double overallRating = ratingList.stream().mapToDouble(Rating::getRating).average().orElse(Double.NaN);
    if (!overallRating.isNaN()) {
      topicService.updateOverallRating(UtilHelper.roundDecimalPlaces(overallRating, 1), rating.getTopic().getTopicId());
    }

  }
}
