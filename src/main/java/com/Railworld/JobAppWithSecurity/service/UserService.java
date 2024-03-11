package com.Railworld.JobAppWithSecurity.service;

import com.Railworld.JobAppWithSecurity.model.User;
import com.Railworld.JobAppWithSecurity.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public User saveUser(User user){
        System.out.println(user.getPassword() + " is the password before encoding");
        user.setPassword(encoder.encode(user.getPassword()));
        System.out.println(user.getPassword() + " is the password after encoding");
        return userRepo.save(user);
    }
}
