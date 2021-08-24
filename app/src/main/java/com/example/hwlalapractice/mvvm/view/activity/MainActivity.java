package com.example.hwlalapractice.mvvm.view.activity;

import androidx.annotation.RequiresApi;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;

import com.example.hwlalapractice.R;
import com.example.hwlalapractice.databinding.ActivityMainBinding;
import com.example.hwlalapractice.manager.PrefManager;

public class MainActivity extends BaseActivity<ActivityMainBinding>  {


   private NavController navController;


    @Override
    protected ActivityMainBinding initBindingRef() {
        return ActivityMainBinding.inflate(getLayoutInflater());
    }

    @Override
    protected View initRoot() {
        return binding.getRoot();
    }

    @Override
    protected void init() {
        TAG = "Activity_Main";
        prefManager = new PrefManager();
        navController = Navigation.findNavController(this, R.id.fragmentContainerView);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void clicks()
    {
        binding.btn1.setOnClickListener(view -> navController.navigate(R.id.secondFragment));

        binding.login.setOnClickListener(view ->
        {
            String email = binding.etEmail.getText().toString().trim();
            String pwd = binding.etPwd.getText().toString().trim();

            if(TextUtils.equals(email,"kamal") && TextUtils.equals(pwd, "12345"))
            {
                prefManager.saveString("email", email);
                prefManager.saveString("pwd", pwd);

                prefManager.saveString("time", String.valueOf(System.currentTimeMillis()));

                startActivity(new Intent(MainActivity.this, MainActivity2.class));
                finish();
            }
        });
    }

}