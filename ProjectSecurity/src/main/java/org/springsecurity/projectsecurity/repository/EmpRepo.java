package org.springsecurity.projectsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springsecurity.projectsecurity.entity.Employee;

public interface EmpRepo extends JpaRepository<Employee, Integer> {
    public Employee findByEmail(String email);
}
