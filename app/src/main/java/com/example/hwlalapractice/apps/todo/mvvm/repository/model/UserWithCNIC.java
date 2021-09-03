package com.example.hwlalapractice.apps.todo.mvvm.repository.model;

import com.example.hwlalapractice.apps.todo.mvvm.repository.db.roomDB.entity.CNIC;
import com.example.hwlalapractice.apps.todo.mvvm.repository.db.roomDB.entity.User;

public class UserWithCNIC {

    private CNIC cnic;
    private User user;

    public UserWithCNIC(CNIC cnic, User user) {
        this.cnic = cnic;
        this.user = user;
    }

    public CNIC getCnic() {
        return cnic;
    }

    public void setCnic(CNIC cnic) {
        this.cnic = cnic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
