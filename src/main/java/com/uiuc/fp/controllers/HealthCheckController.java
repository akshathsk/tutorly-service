package com.uiuc.fp.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HealthCheckController {

  @GetMapping("/healthCheck")
  String getHealthStatus() {
    return "Doing Good!";
  }

}
