package com.example.hwlalapractice.activity;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import com.example.hwlalapractice.R;
import com.example.hwlalapractice.databinding.ActivityMainBinding;
import com.example.hwlalapractice.utils.Constants;
import com.google.android.material.snackbar.Snackbar;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends BaseActivity<ActivityMainBinding>  {

   private NavController navController;
   private SharedPreferences.Editor editor;

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
        navController = Navigation.findNavController(this, R.id.fragmentContainerView);
        SharedPreferences sp = getPreferences(MODE_PRIVATE);
        editor = sp.edit();
        list = new ArrayList<>();
        set = new HashSet<>();
    }

    @Override
    protected void clicks() {
        binding.btn1.setOnClickListener(view -> navController.navigate(R.id.secondFragment));
        binding.login.setOnClickListener(view -> {
            String email = binding.etEmail.getText().toString().trim();
            String pwd = binding.etPwd.getText().toString().trim();
            list.add(email);
            list.add(pwd);
            set.addAll(list);
            if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(pwd))
            {
                if(TextUtils.equals(email, "kamal") && TextUtils.equals(pwd, "12345"))
                {
                    editor.putStringSet(Constants.SP_KEY, set);
                    editor.commit();
                    startActivity(new Intent(MainActivity.this, MainActivity2.class));
                }
                else
                    Snackbar.make(binding.getRoot(), "Wrong Email or Password", Snackbar.LENGTH_LONG).show();
            }

        });

    }

}