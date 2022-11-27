package com.uiuc.fp.domain.event;

import com.uiuc.fp.domain.UserSlot;
import com.uiuc.fp.exception.ValidationException;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

@Slf4j
public class UserSlotEventHandler {

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
  @PreRemove
  private void beforeAnyUpdate(UserSlot userSlot) {
    log.debug("Captured userSlot update");
    validateSlotTime(userSlot);
  }
}
