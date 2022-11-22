package com.uiuc.fp.jdbc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserSlots {
  @Getter
  @Setter
  Long slotId;

  @Getter
  @Setter
  Long userId;

  @Getter
  @Setter
  Long topicId;

  @Getter
  @Setter
  Date slotDate;

  @Getter
  @Setter
  Date startTime;

  @Getter
  @Setter
  Date endTime;

  @Getter
  @Setter
  Boolean isBooked;

  @Getter
  @Setter
  Long bookedByUser;
}
