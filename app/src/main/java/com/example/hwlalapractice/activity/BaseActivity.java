package com.example.hwlalapractice.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.Set;

public abstract class BaseActivity<VB> extends AppCompatActivity {
    protected String TAG;
    protected ArrayList<String> list;
    protected Set<String> set;
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
