package com.exam.onlineExam.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exam.onlineExam.Entities.User;

public interface UserRepo  extends JpaRepository<User,Integer>{

    public User findByUserName(String username);
    
}
