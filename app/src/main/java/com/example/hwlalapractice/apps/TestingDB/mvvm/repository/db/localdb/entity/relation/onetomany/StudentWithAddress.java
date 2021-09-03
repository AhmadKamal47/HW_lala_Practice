package com.example.hwlalapractice.apps.TestingDB.mvvm.repository.db.localdb.entity.relation.onetomany;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.hwlalapractice.apps.TestingDB.mvvm.repository.db.localdb.entity.Address;
import com.example.hwlalapractice.apps.TestingDB.mvvm.repository.db.localdb.entity.Student;

import java.util.List;

public class StudentWithAddress {

    @Embedded
    private Student student;

    @Relation(entity = Address.class ,parentColumn = "sid", entityColumn = "std_id")
    private List<Address> address;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }
}
