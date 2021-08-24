package com.example.hwlalapractice.mvvm.viewmodel;

import android.text.TextUtils;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hwlalapractice.manager.PrefManager;


public class LoginViewModel extends ViewModel {
    private MutableLiveData<Boolean> isSessionExpiredLiveData;

    public LoginViewModel() {
        isSessionExpiredLiveData = new MutableLiveData<>();
        isLoginSessionExpired();
    }

    public LiveData<Boolean> getIsSessionExpiredLiveData() {
        if(isSessionExpiredLiveData == null)
            isLoginSessionExpired();
        return isSessionExpiredLiveData;
    }


    public void isLoginSessionExpired() {
        PrefManager prefManager = new PrefManager();

        String email = prefManager.getString("email");
        String pwd = prefManager.getString("pwd");
        String timeMilli = prefManager.getString("time", "0");

        long currentTimeMilli = System.currentTimeMillis();
        long timeDifference = currentTimeMilli - Long.parseLong(timeMilli);

        boolean isExpired = (TextUtils.equals(email, "kamal") && TextUtils.equals(pwd, "12345") && timeDifference >= 30000f);

        isSessionExpiredLiveData.setValue(isExpired);
    }
}
