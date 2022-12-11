package com.uiuc.fp.controllers;

import com.uiuc.fp.service.TopicService;
import com.uiuc.fp.service.WalletService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class WalletController {

  private final WalletService walletService;

  public WalletController(WalletService walletService) {
    this.walletService = walletService;
  }

  @GetMapping("/v2/wallets/user/{userId}")
  Object getWalletForUser(@PathVariable Long userId)
  {
    return walletService.getWalletForUser(userId);
  }


}
