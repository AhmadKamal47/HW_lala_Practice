package com.example.hwlalapractice.apps.todo.mvvm.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hwlalapractice.apps.todo.mvvm.repository.model.User;

import java.util.List;

public class UserViewModel extends ViewModel {
    MutableLiveData<List<User>> listMutableLiveData;

    public UserViewModel() {
        listMutableLiveData = new MutableLiveData<>();
    }

    public void saveDataToLiveData(List<User> userList)
    {
        listMutableLiveData.setValue(userList);
    }

    public MutableLiveData<List<User>> getListMutableLiveData() {
        return listMutableLiveData;
    }
}
