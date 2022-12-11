package com.uiuc.fp.domain;

import com.uiuc.fp.event.RatingEventHandler;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EntityListeners(RatingEventHandler.class)
@Entity
public class Rating implements Serializable {

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
  @Min(value = 1, message = "Please provide a value in range 1-5")
  @Max(value = 5, message = "Please provide a value in range 1-5")
  private Double rating;

}
