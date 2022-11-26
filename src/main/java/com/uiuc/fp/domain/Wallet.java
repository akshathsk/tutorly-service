package com.uiuc.fp.domain;

import lombok.*;

import javax.persistence.*;

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

  private Double credit;

}
