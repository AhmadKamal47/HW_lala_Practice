package com.example.hwlalapractice.mvvm.view.activity;

import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.hwlalapractice.databinding.ActivitySplashBinding;
import com.example.hwlalapractice.manager.PrefManager;
import com.example.hwlalapractice.mvvm.viewmodel.LoginViewModel;

public class SplashActivity extends BaseActivity<ActivitySplashBinding> {

    private LoginViewModel loginViewModel;
    private final Handler handler = new Handler();

    @Override
    protected View initRoot() {
        return binding.getRoot();
    }

    @Override
    protected ActivitySplashBinding initBindingRef() {
        return ActivitySplashBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void init() {
        TAG = "LOGD";
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        loginViewModel.getIsSessionExpiredLiveData().observe(this, isExpired -> {
            handler
                    .postDelayed(() -> {
                        Class<?> toScreen = MainActivity.class;
                        if (!isExpired) {
                            toScreen = MainActivity2.class;
                        }
                        startActivity(new Intent(SplashActivity.this, toScreen));
                        finish();
                    }, 3000);
        });
    }

    @Override
    protected void clicks() {

    }
}