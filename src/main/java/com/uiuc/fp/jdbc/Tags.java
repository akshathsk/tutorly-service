package com.uiuc.fp.jdbc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Tags {
  @Getter
  @Setter
  Long tagId;

  @Getter
  @Setter
  String tagName;
}
