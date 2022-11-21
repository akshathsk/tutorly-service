package com.uiuc.fp.jdbc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Wallet {
  @Getter
  @Setter
  Long walletId;

  @Getter
  @Setter
  Long userId;

  @Getter
  @Setter
  Double credit;
}
