package com.example.hwlalapractice.apps.TestingDB.mvvm.repository.db.localdb.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.hwlalapractice.apps.TestingDB.mvvm.repository.db.localdb.entity.Address;
import com.example.hwlalapractice.apps.TestingDB.mvvm.repository.db.localdb.entity.Student;
import com.example.hwlalapractice.apps.TestingDB.mvvm.repository.db.localdb.entity.relation.onetomany.StudentWithAddress;

import java.util.List;

@Dao
public interface StudentDao {

    @Insert
    long createStudent(Student student);

    @Insert
    void createAddress(Address address);

    @Query("select * from students where name = :name LIMIT 1")
    Student findStudent(String name);

    @Update
    void updateStudent(Student student);

    @Transaction
    @Query("select * from students")
    List<StudentWithAddress> getAllStudentWithAddresses();



}
