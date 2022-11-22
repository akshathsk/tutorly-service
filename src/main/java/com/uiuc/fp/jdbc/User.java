package com.uiuc.fp.jdbc;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.Setter;
import lombok.Getter;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
  @Getter
  @Setter
  Long userId;

  @Getter
  @Setter
  String userName;

  @Setter
  @Getter
  String email;

  @Getter
  @Setter
  String university;

  @Getter
  @Setter
  String userDegree;

  @Getter
  @Setter
  String phoneNumber;
}
