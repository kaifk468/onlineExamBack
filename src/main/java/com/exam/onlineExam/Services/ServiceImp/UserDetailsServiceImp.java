package com.exam.onlineExam.Services.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.exam.onlineExam.Entities.User;
import com.exam.onlineExam.Repositories.UserRepo;
import com.exam.onlineExam.Services.UserService;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        User userDetails = userService.findUserByUserName(username);
        if(userDetails==null)
        throw new UsernameNotFoundException("No user found in the record");
        return userDetails;
    }
    
}
