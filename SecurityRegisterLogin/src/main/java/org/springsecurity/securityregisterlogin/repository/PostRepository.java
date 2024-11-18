package org.springsecurity.securityregisterlogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springsecurity.securityregisterlogin.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
