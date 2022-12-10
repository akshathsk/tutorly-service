package com.uiuc.fp.repository;

import com.uiuc.fp.domain.User;
import com.uiuc.fp.domain.UserSlot;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserSlotRepository extends CrudRepository<UserSlot, Long> {

  List<UserSlot> findAllByUserIs(User user);

  List<UserSlot> findAllByBookedByUserIs(User user);
}
