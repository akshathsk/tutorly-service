package com.uiuc.fp.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.uiuc.fp.domain.event.UserSlotEventHandler;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EntityListeners(UserSlotEventHandler.class)
@Entity
public class UserSlot {

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long slotId;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "topic_id")
  private Topic topic;

  @NotNull(message = "Slot Date cannot be empty")
  @Temporal(TemporalType.DATE)
  private Date slotDate;

  @NotNull(message = "Start time cannot be empty")
  @JsonFormat(pattern = "HH:mm:ss")
  private LocalTime startTime;

  @NotNull(message = "End time cannot be empty")
  @JsonFormat(pattern = "HH:mm:ss")
  private LocalTime endTime;

  private Boolean isBooked;

  @ManyToOne
  @JoinColumn(name = "booked_by_user_id")
  private User bookedByUser;

}
