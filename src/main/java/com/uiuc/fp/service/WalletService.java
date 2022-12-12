package com.uiuc.fp.service;

import com.uiuc.fp.domain.User;
import com.uiuc.fp.domain.UserSlot;
import com.uiuc.fp.domain.Wallet;
import com.uiuc.fp.exception.ValidationException;
import com.uiuc.fp.repository.WalletRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class WalletService {

  public static final double DEFAULT_CREDIT = 100D;
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
      if (wallet.getUser().getUserId().longValue() == userSlot.getBookedByUser().getUserId().longValue()) {
        // Student wallet
        wallet.setCredit(wallet.getCredit() - userSlot.getTopic().getCreditPerHr());
      } else if (wallet.getUser().getUserId().longValue() == userSlot.getUser().getUserId().longValue()) {
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

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public Object saveDefaultWalletForUser(User user) {

    Wallet wallet = new Wallet();
    wallet.setCredit(DEFAULT_CREDIT);
    wallet.setUser(user);

    return walletRepository.save(wallet);
  }
}
