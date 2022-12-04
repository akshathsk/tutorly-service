package com.uiuc.fp.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Tag implements Serializable {

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long tagId;

  private String tagName;

  @ManyToMany
  @JoinTable(name = "topic_tags")
  private List<Topic> topics;

}
