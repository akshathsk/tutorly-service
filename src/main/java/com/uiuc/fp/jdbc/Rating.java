package com.uiuc.fp.jdbc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Rating {
  @Getter
  @Setter
  Long ratingId;

  @Getter
  @Setter
  Long userId;

  @Getter
  @Setter
  Long tutorId;

  @Getter
  @Setter
  Long topicId;

  @Getter
  @Setter
  String description;

  @Getter
  @Setter
  Double rating;
}
