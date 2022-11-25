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

  @OneToOne
  @JoinColumn(name = "user_id")
  private User user;

  @OneToOne
  @JoinColumn(name = "tutor_id")
  private User tutor;

  @OneToOne
  @JoinColumn(name = "topic_id")
  private Topic topic;

  private String description;

  private Double rating;

}
