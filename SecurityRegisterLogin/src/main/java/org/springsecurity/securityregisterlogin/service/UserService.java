package org.springsecurity.securityregisterlogin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springsecurity.securityregisterlogin.entity.User;
import org.springsecurity.securityregisterlogin.repository.UserRepo;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User saveUser(User user) {
        User newUser = userRepo.save(user);
        return newUser;
    }
}
