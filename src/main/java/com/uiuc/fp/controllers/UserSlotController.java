package com.uiuc.fp.controllers;

import com.uiuc.fp.service.UserSlotService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserSlotController {

  private final UserSlotService userSlotService;

  public UserSlotController(UserSlotService userSlotService) {
    this.userSlotService = userSlotService;
  }


  @GetMapping("/v2/userSlots/{userId}")
  Object getUserSlot(@PathVariable Long userId)
  {
    return userSlotService.getUserSlotByUserId(userId);
  }

  @GetMapping("/v2/userSlots/booked/{userId}")
  Object getUserSlotBookedBy(@PathVariable Long userId)
  {
    return userSlotService.getUserSlotBookedBy(userId);
  }

  @GetMapping("/v2/userSlots/available/{userId}")
  Object getAvailableUserSlots(@PathVariable Long userId)
  {
    return userSlotService.getAvailableUserSlots(userId);
  }
}
