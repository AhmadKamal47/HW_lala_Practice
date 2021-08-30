package com.example.hwlalapractice.mvvm.view.activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.hwlalapractice.apps.todo.mvvm.view.activity.TodoMainActivity;
import com.example.hwlalapractice.apps.todo.mvvm.viewmodel.LoginViewModel;

public abstract class BaseActivity<VB> extends AppCompatActivity {

    protected VB  mBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = initBindingRef();
        setContentView(initRoot());
        initRef();
        clicks();


    }

    protected abstract View initRoot();
    protected abstract VB initBindingRef();
    protected abstract void initRef();
    protected abstract void clicks();


}
