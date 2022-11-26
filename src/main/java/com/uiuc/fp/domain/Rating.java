package com.uiuc.fp.domain;

import lombok.*;

import javax.persistence.*;

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

  private Double rating;

}
