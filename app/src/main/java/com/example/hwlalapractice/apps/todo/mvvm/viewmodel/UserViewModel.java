package com.example.hwlalapractice.apps.todo.mvvm.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hwlalapractice.apps.todo.mvvm.repository.db.roomDB.dao.CNICDao;
import com.example.hwlalapractice.apps.todo.mvvm.repository.db.roomDB.dao.UserDao;
import com.example.hwlalapractice.apps.todo.mvvm.repository.db.roomDB.database.MyRoom;
import com.example.hwlalapractice.apps.todo.mvvm.repository.db.roomDB.entity.CNIC;
import com.example.hwlalapractice.apps.todo.mvvm.repository.db.roomDB.entity.User;
import com.example.hwlalapractice.apps.todo.mvvm.repository.model.UserWithCNIC;

import java.util.ArrayList;
import java.util.List;

public class UserViewModel extends ViewModel {
    MutableLiveData<List<UserWithCNIC>> userMutableLiveDataList;
    UserDao userDao;
    CNICDao cnicDao;

    public UserViewModel()
    {
        userDao = MyRoom.getInstance().getUserDao();
        cnicDao = MyRoom.getInstance().getCnicDao();
        userMutableLiveDataList = new MutableLiveData<>();
    }

    public void saveData(User user)
    {
        userDao.createUser(user);
        fetchData();
    }

    public void fetchData() {
        List<CNIC> cnicList = cnicDao.selectAllCNICs();


    }

    public MutableLiveData<List<UserWithCNIC>> getListMutableLiveData()
    {
        if(userMutableLiveDataList == null){
            userMutableLiveDataList = new MutableLiveData<>();
            fetchData();
        }

        return userMutableLiveDataList;
    }
}
