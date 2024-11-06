package org.springsecurity.full.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springsecurity.full.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

    public User findByEmail(String email);

}
