package com.exam.onlineExam.Services.ServiceImp;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.onlineExam.Entities.User;
import com.exam.onlineExam.Entities.User_Role;
import com.exam.onlineExam.Repositories.UserRepo;
import com.exam.onlineExam.Services.UserService;

@Service
public class userServiceImp implements UserService {

    @Autowired
    UserRepo userRepo;


    @Override
    public User createUser(User user, Set<User_Role> user_Roles) {
        // TODO Auto-generated method stub


        User local=userRepo.findByUserName(user.getUserName());
        if(local==null)
        {

            user.getUserRole().addAll(user_Roles);
            local=userRepo.save(user);
            System.out.println("user saved to database--------------------");
        }
        else
        System.out.println("user already exist--------------------");
        return local;
    }


    @Override
    public User findUserByUserName(String userName) {
        // TODO Auto-generated method stub
        return userRepo.findByUserName(userName);
    }
    
}
