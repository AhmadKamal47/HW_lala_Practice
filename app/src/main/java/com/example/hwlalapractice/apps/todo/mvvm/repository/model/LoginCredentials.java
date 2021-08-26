package com.example.hwlalapractice.apps.todo.mvvm.repository.model;

import android.graphics.drawable.Drawable;

public class LoginCredentials {
    private String email;
    private String pwd;
    private UserRole userRole;

    public LoginCredentials(String email, String pwd, UserRole userRole) {
        this.email = email;
        this.pwd = pwd;
        this.userRole = userRole;
    }

    public String getEmail() {
        return email;
    }

    public String getPwd() {
        return pwd;
    }

    public UserRole getDrawableID() {
        return userRole;
    }
}
