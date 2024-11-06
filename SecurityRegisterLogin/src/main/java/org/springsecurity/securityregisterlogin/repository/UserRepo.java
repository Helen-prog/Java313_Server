package org.springsecurity.securityregisterlogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springsecurity.securityregisterlogin.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
}
