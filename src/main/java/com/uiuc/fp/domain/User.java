package com.uiuc.fp.domain;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long userId;

  @NotNull
  private String userName;

  @Email(message = "Please provide a valid email")
  @NotNull(message = "Email cannot be empty")
  private String email;

  private String university;

  private String userDegree;

  @NotNull(message = "Phone Number cannot be empty")
  private String phoneNumber;

}
