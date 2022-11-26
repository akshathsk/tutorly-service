package com.uiuc.fp.util.email.service;

import com.uiuc.fp.util.email.dto.EmailDetails;

public interface IEmailService {

  String sendMail(EmailDetails details);

}
