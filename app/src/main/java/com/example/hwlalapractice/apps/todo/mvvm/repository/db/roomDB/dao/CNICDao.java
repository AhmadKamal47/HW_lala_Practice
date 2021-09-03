package com.example.hwlalapractice.apps.todo.mvvm.repository.db.roomDB.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.hwlalapractice.apps.todo.mvvm.repository.db.roomDB.entity.CNIC;

import java.util.List;

@Dao
public interface CNICDao {

    @Insert
    long insert(CNIC cnic);

    @Delete
    void deleteCNIC(CNIC... cnic);

    @Update
    void updateCNIC(CNIC... cnic);

    @Query("select * from cnic")
    List<CNIC> selectAllCNICs();
}
