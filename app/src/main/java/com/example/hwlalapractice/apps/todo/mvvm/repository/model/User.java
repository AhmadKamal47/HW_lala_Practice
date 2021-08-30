package com.example.hwlalapractice.apps.todo.mvvm.repository.model;

public class User {
    String name;
    String address;
    String cnic;

    public User(String name, String address, String cnic) {
        this.name = name;
        this.address = address;
        this.cnic = cnic;
    }


    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCnic() {
        return cnic;
    }
}
