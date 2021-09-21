package com.example.hwlalapractice.apps.TestingDB.mvvm.repository.db.localdb.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.hwlalapractice.apps.TestingDB.mvvm.repository.db.localdb.entity.Address;
import com.example.hwlalapractice.apps.TestingDB.mvvm.repository.db.localdb.entity.Student;
import com.example.hwlalapractice.apps.TestingDB.mvvm.repository.db.localdb.entity.relation.onetomany.StudentWithAddress;

import java.util.List;

@Dao
public interface BaseDao<T> {

    @Insert
    long create(T obj);

    @Insert
    void createWithoutId(T obj);

    @Update
    void update(T student);

    @Delete
    void delete(long id);
}
