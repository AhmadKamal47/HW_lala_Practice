package com.example.hwlalapractice.apps.todo.mvvm.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hwlalapractice.R;
import com.example.hwlalapractice.apps.todo.mvvm.repository.model.LoginCredentials;
import com.example.hwlalapractice.apps.todo.mvvm.repository.model.UserRole;

import java.util.ArrayList;
import java.util.List;

public class LoginViewModel extends ViewModel {

    private MutableLiveData<LoginCredentials> credentialsMutableLiveData;
    private MutableLiveData<List<UserRole>> userRoleMutableLiveData;

    public LoginViewModel() {
        credentialsMutableLiveData = new MutableLiveData<>();
        userRoleMutableLiveData = new MutableLiveData<>();
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
        userRoleMutableLiveData.setValue(list);
    }

    public MutableLiveData<List<UserRole>> getUserRoleMutableLiveData() {
        return userRoleMutableLiveData;
    }
}
