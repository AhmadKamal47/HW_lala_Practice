package com.example.hwlalapractice.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import com.example.hwlalapractice.databinding.ActivitySplashBinding;
import com.example.hwlalapractice.utils.Constants;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SplashActivity extends BaseActivity<ActivitySplashBinding> {

    SharedPreferences sp;
    Set<String> set;

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
        set = new HashSet<>();
        list = new ArrayList<>();
        sp = getPreferences(MODE_PRIVATE);
        if(sp.contains(Constants.SP_KEY))
        {
            set = sp.getStringSet(Constants.SP_KEY, null);
            if(!set.isEmpty())
            {

            }
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }, 5000);
    }

    @Override
    protected void clicks() {

    }
}