package com.example.hwlalapractice.apps.todo.mvvm.repository.db.roomDB.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {

    @PrimaryKey(autoGenerate = true)
//    @ColumnInfo(name = "id")
    long id;

//    @ColumnInfo(name = "name")
    String name;

//    @ColumnInfo(name = "address")
    String address;

//    @ColumnInfo(name = "cnic_id")
    String cnic;

    public User(String name, String address, String cnic) {
        this.name = name;
        this.address = address;
        this.cnic = cnic;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }
}
