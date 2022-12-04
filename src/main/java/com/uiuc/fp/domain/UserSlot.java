package com.uiuc.fp.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.uiuc.fp.event.UserSlotEventHandler;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EntityListeners(UserSlotEventHandler.class)
@Entity
public class UserSlot implements Serializable {

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long slotId;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "topic_id")
  private Topic topic;

  @Temporal(TemporalType.DATE)
  private Date slotDate;

  @JsonFormat(pattern = "HH:mm:ss")
  private LocalTime startTime;

  @JsonFormat(pattern = "HH:mm:ss")
  private LocalTime endTime;

  private Boolean isBooked;

  @ManyToOne
  @JoinColumn(name = "booked_by_user_id")
  private User bookedByUser;

}
