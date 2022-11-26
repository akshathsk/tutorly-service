package com.uiuc.fp.util.email.controller;

import com.uiuc.fp.util.email.dto.EmailDetails;
import com.uiuc.fp.util.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class is only to test the email util.
 * TODO: Delete this package com.uiuc.fp.util.email.controller
 */
@RestController
public class EmailTest {

  @Autowired
  private EmailService emailService;

  @PostMapping("/sendMail")
  public String
  sendMail(@RequestBody EmailDetails details) {
    String status
            = emailService.sendMail(details);

    return status;
  }
}