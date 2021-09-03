package com.example.hwlalapractice.apps.TestingDB.mvvm.repository.db.localdb.roomdb;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.hwlalapractice.MyApp;
import com.example.hwlalapractice.apps.TestingDB.mvvm.repository.db.localdb.Dao.StudentDao;
import com.example.hwlalapractice.apps.TestingDB.mvvm.repository.db.localdb.entity.Address;
import com.example.hwlalapractice.apps.TestingDB.mvvm.repository.db.localdb.entity.Student;

@Database(entities = {Student.class, Address.class},version = 2)
public abstract class Localdb extends RoomDatabase {

    private static final String DATABASE_NAME = "TESTING_DATABASE";
    private static Localdb instance;

    public static Localdb getInstance(){
        if(instance == null)
        {
            instance = Room
                    .databaseBuilder(
                            MyApp.getInstance().getAppContext(),
                            Localdb.class,
                            DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigrationFrom(1)
                    .build();
            return instance;
        }
        return instance;
    }

    public abstract StudentDao getStudentDao();
}
