package com.example.hwlalapractice.mvvm.repository.model;

public class LoginCredentials {
    String email;
    String pwd;

    public LoginCredentials(String email, String pwd) {
        this.email = email;
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public String getPwd() {
        return pwd;
    }
}
