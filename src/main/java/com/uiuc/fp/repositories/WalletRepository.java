package com.uiuc.fp.repositories;

import com.uiuc.fp.domain.Wallet;
import org.springframework.data.repository.CrudRepository;

public interface WalletRepository extends CrudRepository<Wallet, Long> {
}
