package com.exam.onlineExam.Entities;

public class JwtRequest {
    private String userName;
    private String password;

    
    public JwtRequest() {
    }


    public String getUsername() {
        return userName;
    }


    public void setUsername(String username) {
        this.userName = username;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    
    
}
