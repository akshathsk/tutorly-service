package com.uiuc.fp.repository;

import com.uiuc.fp.domain.User;
import com.uiuc.fp.domain.Wallet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WalletRepository extends CrudRepository<Wallet, Long> {

  List<Wallet> findByUserIn(List<User> users);

  Wallet findByUser(User user);
}
