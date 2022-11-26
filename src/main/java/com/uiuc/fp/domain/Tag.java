package com.uiuc.fp.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Tag {

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long tagId;

  private String tagName;

  @ManyToMany
  @JoinTable(name = "topic_tags")
  private List<Topic> topics;

}
