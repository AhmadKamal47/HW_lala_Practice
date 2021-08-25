package com.example.hwlalapractice.apps.todo.mvvm.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.hwlalapractice.databinding.ActivityLoginBinding;
import com.example.hwlalapractice.databinding.ActivityTodoMainBinding;
import com.example.hwlalapractice.mvvm.view.activity.BaseActivity;

public class TodoMainActivity extends BaseActivity<ActivityTodoMainBinding> {

    @Override
    protected ActivityTodoMainBinding initBindingRef() {
        return ActivityTodoMainBinding.inflate(getLayoutInflater());
    }

    @Override
    protected View initRoot() {
        return mBinding.getRoot();
    }
    @Override
    protected void initRef() {

    }

    @Override
    protected void clicks() {

    }
}