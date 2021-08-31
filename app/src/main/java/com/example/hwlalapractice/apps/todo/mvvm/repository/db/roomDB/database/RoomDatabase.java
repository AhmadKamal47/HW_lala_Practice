package com.example.hwlalapractice.apps.todo.mvvm.repository.db.roomDB.database;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;

import com.example.hwlalapractice.MyApp;
import com.example.hwlalapractice.apps.todo.mvvm.repository.db.roomDB.dao.UserDao;
import com.example.hwlalapractice.apps.todo.mvvm.repository.db.roomDB.entity.User;

@Database(entities = User.class, version = 1)
public abstract class RoomDatabase extends androidx.room.RoomDatabase {

    private static final String DATABASE_NAME = "mydatabase";
    private static RoomDatabase instance;


    public static RoomDatabase getInstance(){
        if(instance == null)
        {
            instance = Room
                    .databaseBuilder(MyApp.getInstance().getAppContext(), RoomDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
    public abstract UserDao getUserDao();
}
