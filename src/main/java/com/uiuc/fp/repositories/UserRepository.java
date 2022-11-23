package com.uiuc.fp.repositories;

import com.uiuc.fp.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
