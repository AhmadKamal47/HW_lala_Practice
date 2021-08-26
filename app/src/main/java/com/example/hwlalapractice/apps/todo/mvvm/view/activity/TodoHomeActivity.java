package com.example.hwlalapractice.apps.todo.mvvm.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.hwlalapractice.databinding.ActivityTodoHomeBinding;
import com.example.hwlalapractice.databinding.ActivityTodoMainBinding;
import com.example.hwlalapractice.mvvm.view.activity.BaseActivity;

public class TodoHomeActivity extends BaseActivity<ActivityTodoHomeBinding> {

    @Override
    protected View initRoot() {
        return mBinding.getRoot();
    }

    @Override
    protected ActivityTodoHomeBinding initBindingRef() {
        return ActivityTodoHomeBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initRef() {

    }

    @Override
    protected void clicks() {

    }
}