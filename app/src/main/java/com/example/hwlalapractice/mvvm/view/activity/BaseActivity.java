package com.example.hwlalapractice.mvvm.view.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hwlalapractice.manager.PrefManager;

public abstract class BaseActivity<VB> extends AppCompatActivity {
    protected String TAG;
    protected PrefManager prefManager;
    protected VB binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = initBindingRef();
        setContentView(initRoot());
        init();
        clicks();
    }

    protected abstract View initRoot();
    protected abstract VB initBindingRef();
    protected abstract void init();
    protected abstract void clicks();

    protected void logs(String msg)
    {
        Log.d(TAG, msg);
    }

    
}
