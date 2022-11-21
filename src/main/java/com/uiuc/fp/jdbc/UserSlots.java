package com.uiuc.fp.jdbc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
  String date;

  @Getter
  @Setter
  String startTime;

  @Getter
  @Setter
  String endTime;

  @Getter
  @Setter
  Boolean isBooked;

  @Getter
  @Setter
  Long bookedByUser;
}
