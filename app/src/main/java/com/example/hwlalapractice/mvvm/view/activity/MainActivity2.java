package com.example.hwlalapractice.mvvm.view.activity;

import android.content.Intent;
import android.view.View;

import com.example.hwlalapractice.databinding.ActivityMain2Binding;

public class MainActivity2 extends BaseActivity<ActivityMain2Binding> {

    @Override
    protected ActivityMain2Binding initBindingRef() {
        return ActivityMain2Binding.inflate(getLayoutInflater());
    }

    @Override
    protected View initRoot() {
        return binding.getRoot();
    }

    @Override
    protected void init() {
        TAG = "MainActivity2";
    }

    @Override
    protected void clicks() {
        binding.tvAct2.setOnClickListener(view ->
                startActivity(new Intent(MainActivity2.this, MainActivity3.class)));
    }

}