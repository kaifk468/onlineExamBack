package com.exam.onlineExam.Entities;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority{

    private String authority;
    
    

    public Authority() {
    }
    
    public Authority(String authority) {
        this.authority = authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
    @Override
    public String getAuthority() {
        // TODO Auto-generated method stub
        return this.authority;
    }
}
