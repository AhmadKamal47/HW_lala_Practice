package com.example.hwlalapractice.mvvm.view.activity;

import android.view.View;

import com.example.hwlalapractice.databinding.ActivityMain3Binding;

public class MainActivity3 extends BaseActivity<ActivityMain3Binding> {

    @Override
    protected ActivityMain3Binding initBindingRef() {
        return ActivityMain3Binding.inflate(getLayoutInflater());
    }

    @Override
    protected View initRoot() {
        return binding.getRoot();
    }

    @Override
    protected void init() {
        TAG = "MainActivity3";

    }

    @Override
    protected void clicks() {

    }
}