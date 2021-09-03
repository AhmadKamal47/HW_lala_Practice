package com.example.hwlalapractice.apps.TestingDB.mvvm.repository.db.localdb.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "addresses",
        foreignKeys = @ForeignKey(
                entity = Student.class,
                parentColumns = "sid",
                childColumns = "std_id"
        ))
public class Address {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String area;
    private String city;
    private String country;
    private long std_id;

    public Address(String area, String city, String country, long std_id) {
        this.area = area;
        this.city = city;
        this.country = country;
        this.std_id = std_id;
    }

    public long getStd_id() {
        return std_id;
    }

    public void setStd_id(long std_id) {
        this.std_id = std_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
