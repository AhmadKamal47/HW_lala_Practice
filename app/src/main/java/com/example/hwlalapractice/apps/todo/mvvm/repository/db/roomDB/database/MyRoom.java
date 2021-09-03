package com.example.hwlalapractice.apps.todo.mvvm.repository.db.roomDB.database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.hwlalapractice.MyApp;
import com.example.hwlalapractice.apps.todo.mvvm.repository.db.roomDB.dao.CNICDao;
import com.example.hwlalapractice.apps.todo.mvvm.repository.db.roomDB.dao.UserDao;
import com.example.hwlalapractice.apps.todo.mvvm.repository.db.roomDB.entity.CNIC;
import com.example.hwlalapractice.apps.todo.mvvm.repository.db.roomDB.entity.User;

@Database(entities = {User.class, CNIC.class}, version = 2)
public abstract class MyRoom extends RoomDatabase {

    private static final String DATABASE_NAME = "MyDatabase";
    private static MyRoom instance;

    public static MyRoom getInstance(){
        if(instance == null)
        {
            instance = Room
                    .databaseBuilder(MyApp.getInstance().getAppContext(), MyRoom.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigrationFrom(1)
                    .build();
        }
        return instance;
    }

    public abstract UserDao getUserDao();
    public abstract CNICDao getCnicDao();


}
