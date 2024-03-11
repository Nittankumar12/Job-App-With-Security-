package com.Railworld.JobAppWithSecurity.service;

import com.Railworld.JobAppWithSecurity.model.User;
import com.Railworld.JobAppWithSecurity.model.UserPrincipal;
import com.Railworld.JobAppWithSecurity.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

         User user = userRepo.findByUsername(username);
         if(user == null){
             System.out.println("User not found");
             throw new UsernameNotFoundException("User 404");
         }
        return new UserPrincipal(user);
    }
}
