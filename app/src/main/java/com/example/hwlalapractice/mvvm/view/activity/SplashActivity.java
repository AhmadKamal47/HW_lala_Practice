package com.example.hwlalapractice.mvvm.view.activity;

import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;

import com.example.hwlalapractice.databinding.ActivitySplashBinding;
import com.example.hwlalapractice.manager.PrefManager;

public class SplashActivity extends BaseActivity<ActivitySplashBinding> {

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
        prefManager = new PrefManager();
    }

    @Override
    protected void onResume() {
        super.onResume();
        new Handler().postDelayed(() -> {

            String email = prefManager.getString("email");
            String pwd = prefManager.getString("pwd");
            String timeMilli = prefManager.getString("time", "0");


            long currentTimeMilli = System.currentTimeMillis();
            long timeDifference = currentTimeMilli - Long.parseLong(timeMilli);

            if(TextUtils.equals(email, "kamal") && TextUtils.equals(pwd, "12345"))
            {
                if(timeDifference < 30000f)
                {
                    startActivity(new Intent(SplashActivity.this, MainActivity2.class));
                    finish();
                }
                else {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                }

            }
            else
            {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }, 3000);
    }



    @Override
    protected void clicks() {

    }
}