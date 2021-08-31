package com.example.hwlalapractice.apps.todo.mvvm.repository.db.roomDB.dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.hwlalapractice.apps.todo.mvvm.repository.db.roomDB.entity.User;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void createUser(User... user);

    @Update
    void updateUser(User... user);

    @Delete
    void deleteUser(User... user);


    @Query("select * from users where name = :value")
    User getUserInfo(String value);

    @Query("select * from users")
    List<User> getAllUser();
}
