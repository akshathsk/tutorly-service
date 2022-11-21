package com.uiuc.fp.service;

import com.uiuc.fp.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  UserDao userDao;

  public String getUsers() {
    return userDao.getUsers();
  }
}
