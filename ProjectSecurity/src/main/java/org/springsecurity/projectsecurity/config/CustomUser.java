package org.springsecurity.projectsecurity.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springsecurity.projectsecurity.entity.Employee;

import java.util.Arrays;
import java.util.Collection;

public class CustomUser implements UserDetails {

    private Employee employee;  //

    public CustomUser(Employee employee) {  //
        this.employee = employee;
    }

    public Employee getEmployee() {  //
        return employee;
    }

    public void setEmployee(Employee employee) {  //
        this.employee = employee;
    }

    // Переопределенные методы из интерфейса
    @Override
    public boolean isAccountNonExpired() {  // Указывает, истек ли срок действия учетной записи пользователя.
        return true;  //
    }

    @Override
    public boolean isAccountNonLocked() {  // Указывает, заблокирован или разблокирован пользователь.
        return true;  //
    }

    @Override
    public boolean isCredentialsNonExpired() {  // Указывает, истек ли срок действия учетных данных пользователя (пароля).
        return true;  //
    }

    @Override
    public boolean isEnabled() {  // Указывает, включен или отключен пользователь.
        return true;  //
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {  // Возвращает полномочия, предоставленные пользователю.
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(employee.getRole()); //
        return Arrays.asList(simpleGrantedAuthority);  //
    }

    @Override
    public String getPassword() {  // Возвращает пароль, используемый для аутентификации пользователя.
        return employee.getPassword();  //
    }

    @Override
    public String getUsername() {  // Возвращает имя пользователя, используемое для аутентификации пользователя.
        return employee.getEmail();  //
    }
}

