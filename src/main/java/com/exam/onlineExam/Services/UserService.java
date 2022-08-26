package com.exam.onlineExam.Services;

import java.util.Set;

import com.exam.onlineExam.Entities.User;
import com.exam.onlineExam.Entities.User_Role;

public interface UserService {

    public User createUser(User user,Set<User_Role> user_Roles);
    
}
