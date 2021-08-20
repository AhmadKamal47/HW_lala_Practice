package com.example.hwlalapractice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.hwlalapractice.databinding.ActivityMain3Binding;
import com.example.hwlalapractice.databinding.ActivityMainBinding;

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
        navController = Navigation.findNavController(this, R.id.home_nav_graph);

    }

    @Override
    protected void clicks() {

    }


}