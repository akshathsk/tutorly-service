package com.uiuc.fp.util.email.service;

import com.uiuc.fp.domain.UserSlot;
import com.uiuc.fp.util.email.dto.EmailDetails;
import freemarker.template.Configuration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.internet.MimeMessage;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class EmailService implements IEmailService {

  @Autowired
  Configuration fmConfiguration;

  @Autowired
  private JavaMailSender javaMailSender;

  @Value("${spring.mail.username}")
  private String sender;

  @Value("${mail.enable}")
  private boolean enableEmail;

  public String sendMail(EmailDetails details) {

    if (!enableEmail) {
      return "Emails are disabled";
    }

    MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    try {
      MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
      mimeMessageHelper.setSubject(details.getSubject());
      mimeMessageHelper.setFrom(sender);
      mimeMessageHelper.setTo(details.getRecipient().split(","));
      mimeMessageHelper.setText(details.getMsgBody(), true);
      javaMailSender.send(mimeMessageHelper.getMimeMessage());
    } catch (Exception e) {
      log.info(e.getMessage());
      return "Failed to send email.";
    }
    return "Email sent successfully!";

  }

  public String getSlotBookingEmailContent(UserSlot userSlot) {

    Map<String, Object> model = new HashMap<>();
    model.put("student", userSlot.getBookedByUser().getUserName());
    model.put("tutor", userSlot.getUser().getUserName());
    model.put("slotDate", userSlot.getSlotDate().toString());
    model.put("startTime", userSlot.getStartTime().toString());
    model.put("endTime", userSlot.getEndTime().toString());
    model.put("email", userSlot.getUser().getEmail());
    model.put("phone", userSlot.getUser().getPhoneNumber());
    model.put("adminEmail", sender);
    model.put("dateNow", LocalDate.now().toString());

    StringBuffer content = new StringBuffer();
    try {
      content.append(FreeMarkerTemplateUtils.processTemplateIntoString(fmConfiguration.getTemplate("email.ftlh"), model));
    } catch (Exception e) {
      log.info(e.getMessage());
    }
    return content.toString();

  }

}