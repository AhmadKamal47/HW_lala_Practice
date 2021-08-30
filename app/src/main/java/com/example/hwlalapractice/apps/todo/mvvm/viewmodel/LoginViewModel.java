package com.example.hwlalapractice.apps.todo.mvvm.viewmodel;

import android.content.Context;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.hwlalapractice.apps.todo.mvvm.repository.model.LoginCredentials;
import com.example.hwlalapractice.apps.todo.mvvm.repository.model.UserRole;
import com.example.hwlalapractice.apps.todo.mvvm.view.activity.TodoMainActivity;

import java.util.List;

public class LoginViewModel extends ViewModel {

    private MutableLiveData<LoginCredentials> credentialsMutableLiveData;
    private MutableLiveData<List<UserRole>> userRoleMutableLiveDataList;

    public LoginViewModel() {
        credentialsMutableLiveData = new MutableLiveData<>();
        userRoleMutableLiveDataList = new MutableLiveData<>();
    }

    public MutableLiveData<LoginCredentials> getCredentialsMutableLiveData() {
        return credentialsMutableLiveData;
    }

    public void saveDataToLiveData(LoginCredentials loginCredentials)
    {
        credentialsMutableLiveData.setValue(loginCredentials);
    }

    public void saveUserRoleListToLiveData(List<UserRole> list)
    {
        userRoleMutableLiveDataList.setValue(list);
    }

    public MutableLiveData<List<UserRole>> getUserRoleMutableLiveDataList() {
        return userRoleMutableLiveDataList;
    }






}
