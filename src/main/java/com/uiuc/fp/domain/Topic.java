package com.uiuc.fp.domain;

import lombok.*;

import javax.persistence.*;

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

  private String topicName;

  private String description;

  private Double creditPerHr;

  private Double experienceLevel;

  private Double overallRating;

}
