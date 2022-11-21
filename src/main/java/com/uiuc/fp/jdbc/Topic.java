package com.uiuc.fp.jdbc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Topic {
  @Getter
  @Setter
  Long topicId;

  @Getter
  @Setter
  Long userId;

  @Getter
  @Setter
  String name;

  @Getter
  @Setter
  String description;

  @Getter
  @Setter
  Double creditPerHr;

  @Getter
  @Setter
  Double experienceLevel;

  @Getter
  @Setter
  Double overallRating;
}
