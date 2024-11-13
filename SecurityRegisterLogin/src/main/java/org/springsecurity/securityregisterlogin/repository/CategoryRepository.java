package org.springsecurity.securityregisterlogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springsecurity.securityregisterlogin.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    public Boolean existsByName(String name);
}
