package com.exam.onlineExam.Entities;

public class JwtResposne {
    
    private String token;

    
    public JwtResposne() {
    }

    public JwtResposne(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    
}
