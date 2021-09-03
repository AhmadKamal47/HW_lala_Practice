package com.example.hwlalapractice.apps.todo.mvvm.repository.db.roomDB.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {

    @PrimaryKey(autoGenerate = true)
//    @ColumnInfo(name = "id")
    private long id;

//    @ColumnInfo(name = "name")
    private String name;

//    @ColumnInfo(name = "address")
    private String address;

//    @ColumnInfo(name = "cnic_id")
    private long cnic_id;

    public User(String name, String address, long cnic_id) {
        this.name = name;
        this.address = address;
        this.cnic_id = cnic_id;
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

    public long getCnic_id() {
        return cnic_id;
    }

    public void setCnic_id(long cnic_id) {
        this.cnic_id = cnic_id;
    }
}
