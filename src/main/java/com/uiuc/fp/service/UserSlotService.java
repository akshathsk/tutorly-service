package com.uiuc.fp.service;

import com.uiuc.fp.domain.User;
import com.uiuc.fp.domain.UserSlot;
import com.uiuc.fp.repository.UserSlotRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserSlotService {

  private final WalletService walletService;

  private final UserSlotRepository userSlotRepository;

  public UserSlotService(@Lazy WalletService walletService, @Lazy UserSlotRepository userSlotRepository) {
    this.walletService = walletService;
    this.userSlotRepository = userSlotRepository;
  }


  @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
  public void validateWallet(UserSlot userSlot) {

    walletService.validateWallet(userSlot);

  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void updateWallet(UserSlot userSlot) {

    walletService.updateWallet(userSlot);

  }

  public Object getUserSlotByUserId(Long userId) {
    User user = new User();
    user.setUserId(userId);
    return userSlotRepository.findAllByUserIs(user);
  }

  public Object getUserSlotBookedBy(Long userId) {
    User user = new User();
    user.setUserId(userId);
    return userSlotRepository.findAllByBookedByUserIs(user);
  }

  public Object getAvailableUserSlots(Long userId) {
    User user = new User();
    user.setUserId(userId);
    List<UserSlot> topicList = userSlotRepository.findAllByUserIs(user);
    return topicList.stream().filter(x -> !x.getIsBooked()).collect(Collectors.toList());
  }
}
