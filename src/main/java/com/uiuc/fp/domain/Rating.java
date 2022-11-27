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
public class Rating {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long ratingId;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "tutor_id")
  private User tutor;

  @ManyToOne
  @JoinColumn(name = "topic_id")
  private Topic topic;

  private String description;

  @NotNull(message = "Rating cannot be empty")
  @Min(1)
  @Max(5)
  private Double rating;

}
