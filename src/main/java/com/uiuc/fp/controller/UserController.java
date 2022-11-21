package com.uiuc.fp.controller;

import com.uiuc.fp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  UserService userService;

  @RequestMapping("user")
  public @ResponseBody ResponseEntity<String> getUsers() {
    return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
  }

}