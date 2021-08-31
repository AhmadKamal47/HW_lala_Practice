package com.example.hwlalapractice.apps.todo.mvvm.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hwlalapractice.apps.todo.mvvm.repository.db.roomDB.dao.UserDao;
import com.example.hwlalapractice.apps.todo.mvvm.repository.db.roomDB.database.RoomDatabase;
import com.example.hwlalapractice.apps.todo.mvvm.repository.db.roomDB.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserViewModel extends ViewModel {
    MutableLiveData<List<User>> userMutableLiveDataList;
    UserDao userDao;

    public UserViewModel()
    {
        userDao = RoomDatabase.getInstance().getUserDao();
    }

    public void saveData(User user)
    {
        userDao.createUser(user);
        fetchData();
    }

    private void fetchData() {
        List<User> userList = userDao.getAllUser();
        userMutableLiveDataList.setValue(userList);
    }

    public MutableLiveData<List<User>> getListMutableLiveData()
    {
        if(userMutableLiveDataList == null){
            userMutableLiveDataList = new MutableLiveData<>();
            fetchData();
        }

        return userMutableLiveDataList;
    }
}
