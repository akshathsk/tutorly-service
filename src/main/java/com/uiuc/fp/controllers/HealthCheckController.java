package com.uiuc.fp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

  @GetMapping("/healthCheck")
  String getHealthStatus() {
    return "Doing Good!";
  }

}
