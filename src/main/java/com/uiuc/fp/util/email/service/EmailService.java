package com.uiuc.fp.util.email.service;

import com.uiuc.fp.util.email.dto.EmailDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements IEmailService {

  @Autowired
  private JavaMailSender javaMailSender;

  @Value("${spring.mail.username}")
  private String sender;

  public String sendMail(EmailDetails details) {

    try {
      SimpleMailMessage mailMessage
              = new SimpleMailMessage();
      mailMessage.setFrom(sender);
      mailMessage.setTo(details.getRecipient().trim().split(","));
      mailMessage.setText(details.getMsgBody());
      mailMessage.setSubject(details.getSubject());
      javaMailSender.send(mailMessage);
      return "Mail Sent Successfully...";
    } catch (Exception e) {
      return "Error while Sending Mail";
    }
  }
}