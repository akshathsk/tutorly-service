package com.uiuc.fp.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Topic {

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long topicId;

  @ManyToOne
  @JoinColumn(name="user_id")
  private User userId;

  private String topicName;

  private String description;

  private Double creditPerHr;

  private Double experienceLevel;

  private Double overallRating;

  @ManyToMany
  @JoinTable(name = "topic_tags")
  private List<Tag> tags;
}
