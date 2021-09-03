package com.example.hwlalapractice.apps.todo.mvvm.repository.db.roomDB.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cnic")
public class CNIC {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private String cnic_no;
    private String nationality;

    public CNIC(String cnic_no, String nationality)
    {
        this.cnic_no = cnic_no;
        this.nationality = nationality;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCnic_no() {
        return cnic_no;
    }

    public void setCnic_no(String cnic_no) {
        this.cnic_no = cnic_no;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
