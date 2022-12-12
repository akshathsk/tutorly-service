package com.uiuc.fp.event;

import com.uiuc.fp.domain.User;
import com.uiuc.fp.service.WalletService;
import lombok.RequiredArgsConstructor;

import javax.persistence.PostPersist;

@RequiredArgsConstructor
public class UserEventHandler {

  private final WalletService walletService;

  /**
   * Captures all post events on the user table
   *
   * @param user
   */
  @PostPersist
  private void afterInsert(User user) {
    walletService.saveDefaultWalletForUser(user);
  }
}
