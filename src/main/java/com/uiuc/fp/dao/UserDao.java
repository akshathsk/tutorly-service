package com.uiuc.fp.dao;

import com.uiuc.fp.jdbc.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {

  @Autowired
  JdbcTemplate jdbcTemplate;

  public String getUsers() {
    List<String> list = new ArrayList<>();
    list.add("Table data...");
    jdbcTemplate.query(
                    "SELECT * FROM User", new Object[]{},
                    (rs, rowNum) -> new User(rs.getLong("user_id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("university"),
                            rs.getString("degree"),
                            rs.getString("phone_number")))
            .forEach(user -> list.add(user.toString()));
    return list.toString();
  }
}
