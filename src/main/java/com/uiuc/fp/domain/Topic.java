package com.uiuc.fp.domain;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Topic implements Serializable {

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

  @Min(value = 1, message = "Please provide a value greater than 1")
  @Max(value = 5, message = "Please provide a value less than 5")
  private Double overallRating;

}
