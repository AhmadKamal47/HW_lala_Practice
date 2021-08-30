package com.example.hwlalapractice.apps.todo.mvvm.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.example.hwlalapractice.apps.todo.mvvm.repository.model.LoginCredentials;
import com.example.hwlalapractice.apps.todo.mvvm.repository.model.UserRole;
import com.example.hwlalapractice.apps.todo.mvvm.viewmodel.LoginViewModel;
import com.example.hwlalapractice.apps.todo.mvvm.viewmodel.UserViewModel;
import com.example.hwlalapractice.databinding.ActivityTodoHomeBinding;
import com.example.hwlalapractice.mvvm.view.activity.BaseActivity;

import java.util.List;

public class TodoHomeActivity extends BaseActivity<ActivityTodoHomeBinding> {

    private UserViewModel viewModel;
    @Override
    protected ActivityTodoHomeBinding initBindingRef() {
        return ActivityTodoHomeBinding.inflate(getLayoutInflater());
    }

    @Override
    protected View initRoot() {
        return mBinding.getRoot();
    }

    @Override
    protected void initRef() {
        viewModel = new ViewModelProvider(this).get(UserViewModel.class);
    }


    @Override
    protected void clicks() {
        String name = mBinding.etNameTodoHome.getText().toString().trim();
        String address = mBinding.etAddressTodoHome.getText().toString().trim();
        String cnic = mBinding.etCnicTodoHome.getText().toString().trim();

        if(TextUtils.isEmpty(name))
        {
            mBinding.etNameTodoHome.setError("Required Field...");
        }

    }



}