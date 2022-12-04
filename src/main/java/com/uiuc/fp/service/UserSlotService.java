package com.uiuc.fp.service;

import com.uiuc.fp.domain.UserSlot;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserSlotService {

  private final WalletService walletService;

  public UserSlotService(@Lazy WalletService walletService) {
    this.walletService = walletService;
  }


  @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
  public void validateWallet(UserSlot userSlot) {

    walletService.validateWallet(userSlot);

  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void updateWallet(UserSlot userSlot) {

    walletService.updateWallet(userSlot);

  }

}
