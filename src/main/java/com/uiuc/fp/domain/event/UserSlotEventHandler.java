package com.uiuc.fp.domain.event;

import com.uiuc.fp.domain.UserSlot;
import com.uiuc.fp.exception.ValidationException;
import com.uiuc.fp.util.email.dto.EmailDetails;
import com.uiuc.fp.util.email.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Slf4j
public class UserSlotEventHandler {

  @Autowired
  private EmailService emailService;

  private static void validateSlotTime(UserSlot userSlot) {
    if (userSlot.getStartTime() != null
            && userSlot.getEndTime() != null
            && userSlot.getStartTime().compareTo(userSlot.getEndTime()) > 0) {
      throw new ValidationException("Start time cannot be after the end time");
    }
  }

  /**
   * Captures all pre events on the UserSlot table
   *
   * @param userSlot
   */
  @PrePersist
  @PreUpdate
  private void beforeUpdate(UserSlot userSlot) {
    log.debug("Captured userSlot update");
    validateSlotTime(userSlot);
  }

  @PostPersist
  private void afterInsert(UserSlot userSlot) {
    if (userSlot.getIsBooked() != null && userSlot.getIsBooked()) {
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
