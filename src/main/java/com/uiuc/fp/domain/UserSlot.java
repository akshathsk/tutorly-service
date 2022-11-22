package com.uiuc.fp.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class UserSlot {

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long slotId;

  @OneToOne
  private User userId;

  private Long topicId;

  @Temporal(TemporalType.DATE)
  private Date slotDate;

  @Temporal(TemporalType.TIME)
  private Date startTime;

  @Temporal(TemporalType.TIME)
  private Date endTime;

  private Boolean isBooked;

  @ManyToOne
  @JoinColumn(name="booked_by_user_id")
  private User bookedByUser;
}
