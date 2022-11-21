package com.uiuc.fp.jdbc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TopicTags {
  @Getter
  @Setter
  Long topicTagId;

  @Getter
  @Setter
  Long topicId;

  @Getter
  @Setter
  Long tagId;
}
