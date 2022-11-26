package com.uiuc.fp.util.email.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetails {

  private String recipient;
  private String msgBody;
  private String subject;

}