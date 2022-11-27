package com.uiuc.fp.domain;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Wallet {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long walletId;

  @OneToOne
  @JoinColumn(name = "user_id")
  private User user;

  @NotNull(message = "Credit time cannot be empty")
  private Double credit;

}