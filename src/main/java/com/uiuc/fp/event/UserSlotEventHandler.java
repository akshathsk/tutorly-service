package com.uiuc.fp.event;

import com.uiuc.fp.domain.UserSlot;
import com.uiuc.fp.exception.ValidationException;
import com.uiuc.fp.service.UserSlotService;
import com.uiuc.fp.util.email.dto.EmailDetails;
import com.uiuc.fp.util.email.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Slf4j
@RequiredArgsConstructor
public class UserSlotEventHandler {

  private final EmailService emailService;

  private final UserSlotService userSlotService;

  private static void validateSlotTime(UserSlot userSlot) {
    if (userSlot.getSlotDate() == null) {
      throw new ValidationException("Slot Date cannot be empty");
    }

    if (userSlot.getStartTime() == null) {
      throw new ValidationException("Start time cannot be empty");
    }

    if (userSlot.getEndTime() == null) {
      throw new ValidationException("End time cannot be empty");
    }

    if (userSlot.getStartTime().compareTo(userSlot.getEndTime()) > 0) {
      throw new ValidationException("Start time cannot be after the end time");
    }
  }

  /**
   * Captures all pre insert events on the UserSlot table
   *
   * @param userSlot
   */
  @PrePersist
  private void beforeInsert(UserSlot userSlot) {
    validateSlotTime(userSlot);
  }

  /**
   * Captures all pre update events on the UserSlot table
   *
   * @param userSlot
   */
  @PreUpdate
  private void beforeUpdate(UserSlot userSlot) {
    validateSlotTime(userSlot);
    userSlotService.validateWallet(userSlot);
  }

  /**
   * Captures all post events on the UserSlot table
   *
   * @param userSlot
   */
  @PostUpdate
  @PostPersist
  private void afterInsert(UserSlot userSlot) {
    if (userSlot.getIsBooked() != null && userSlot.getIsBooked()) {
      userSlotService.updateWallet(userSlot);
      sendSlotBookedEmail(userSlot);
    }
  }

  private void sendSlotBookedEmail(UserSlot userSlot) {
    try {
      EmailDetails details = new EmailDetails();
      details.setSubject("[AppName] : Your session has been confirmed!");
      details.setMsgBody(emailService.getSlotBookingEmailContent(userSlot));
      details.setRecipient(userSlot.getBookedByUser().getEmail() + "," + userSlot.getUser().getEmail());
      emailService.sendMail(details);
    } catch (Exception e) {
      log.info(e.getMessage(), e);
    }
  }

}
