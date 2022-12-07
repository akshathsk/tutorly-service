package com.uiuc.fp.services;

import com.uiuc.fp.util.client.RestClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Slf4j
public class HealthCheckService {

  @Value("${base.url}")
  private String baseUrl;

  @Value("${cron.enable}")
  private boolean cronEnable;

  @Scheduled(cron = "0/30 * * * * ?")
  public void cronJobSch() {

    if(cronEnable) {
      HttpStatus status = RestClient.get(String.join("/", baseUrl, "healthCheck"));
      log.info("HealthCheck : " + status);
    }
    
  }

}
