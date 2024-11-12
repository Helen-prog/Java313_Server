package org.springsecurity.securityregisterlogin.service;

import org.springsecurity.securityregisterlogin.entity.User;

public interface IUserService {
    public User saveUser(User user);

    public void removeSessionMessage();
}
