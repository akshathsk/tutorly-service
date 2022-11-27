package com.uiuc.fp.domain;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Topic {

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long topicId;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @NotNull(message = "Topic Name cannot be empty")
  private String topicName;

  private String description;

  @NotNull(message = "Credit Rate cannot be empty")
  private Double creditPerHr;

  private Double experienceLevel;

  @Min(1)
  @Max(5)
  private Double overallRating;

}
