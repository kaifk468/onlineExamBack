package com.exam.onlineExam.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.onlineExam.Entities.Role;

public interface RoleRepo extends JpaRepository<Role,Integer> {
    
}
