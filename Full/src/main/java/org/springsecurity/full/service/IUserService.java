package org.springsecurity.full.service;

import org.springsecurity.full.entity.User;

public interface IUserService {
    public User saveUser(User user);

    public void removeSessionMessage();
}
