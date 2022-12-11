package com.uiuc.fp.service;

import com.uiuc.fp.domain.User;
import com.uiuc.fp.domain.UserSlot;
import com.uiuc.fp.domain.Wallet;
import com.uiuc.fp.exception.ValidationException;
import com.uiuc.fp.repository.WalletRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class WalletService {

  private final WalletRepository walletRepository;

  public WalletService(@Lazy WalletRepository walletRepository) {
    this.walletRepository = walletRepository;
  }

  public void validateWallet(UserSlot userSlot) {

    Wallet wallet = walletRepository.findByUser(userSlot.getBookedByUser());

    if (wallet.getCredit() < userSlot.getTopic().getCreditPerHr()) {
      throw new ValidationException("Sorry you don't have enough credits to book this class");
    }

  }

  public void updateWallet(UserSlot userSlot) {

    List<Wallet> wallets = walletRepository.findByUserIn(Arrays.asList(userSlot.getBookedByUser(), userSlot.getUser()));

    wallets.forEach(wallet -> {
      if (wallet.getUser().getUserId() == userSlot.getBookedByUser().getUserId()) {
        // Student wallet
        wallet.setCredit(wallet.getCredit() - userSlot.getTopic().getCreditPerHr());
      } else if (wallet.getUser().getUserId() == userSlot.getUser().getUserId()) {
        // Tutor wallet
        wallet.setCredit(wallet.getCredit() + userSlot.getTopic().getCreditPerHr());
      }
    });
    walletRepository.saveAll(wallets);

  }

  public Object getWalletForUser(Long userId) {
    User user = new User();
    user.setUserId(userId);
    return walletRepository.findByUser(user);
  }
}
