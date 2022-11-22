package com.uiuc.fp.domain;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Tag {

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long tagId;

  private String tagName;

}
