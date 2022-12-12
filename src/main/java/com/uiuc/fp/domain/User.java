package com.uiuc.fp.domain;

import com.uiuc.fp.event.UserEventHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EntityListeners(UserEventHandler.class)
@Entity
public class User implements Serializable {

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
