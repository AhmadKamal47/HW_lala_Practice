package com.example.hwlalapractice.apps.todo.mvvm.view.activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.example.hwlalapractice.R;
import com.example.hwlalapractice.apps.todo.mvvm.repository.model.LoginCredentials;
import com.example.hwlalapractice.apps.todo.mvvm.repository.model.UserRole;
import com.example.hwlalapractice.apps.todo.mvvm.view.adapter.LoginCredentialsAdapter;
import com.example.hwlalapractice.apps.todo.mvvm.viewmodel.LoginViewModel;
import com.example.hwlalapractice.databinding.ActivityTodoMainBinding;
import com.example.hwlalapractice.mvvm.view.activity.BaseActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class TodoMainActivity extends BaseActivity<ActivityTodoMainBinding> {


    private LoginViewModel viewModel;
    private LoginCredentialsAdapter adapter;

    @Override
    protected ActivityTodoMainBinding initBindingRef() {
        return ActivityTodoMainBinding.inflate(getLayoutInflater());
    }

    @Override
    protected View initRoot() {
        return mBinding.getRoot();
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void initRef()
    {
        viewModel = new ViewModelProvider(this).get(LoginViewModel.class); //getting view model object
        viewModel.saveUserRoleListToLiveData(getUserRoleList()); //save userrole list to live data in view model
        observeUserRoleLiveData(); //observing live data for stored userroles.

    }

    private void observeUserRoleLiveData() {
        viewModel.getUserRoleMutableLiveData().observe(this, userRoles -> {
            if (userRoles != null)
            {
                setUpRecyclerView(userRoles);
            }
        });
    }

    private List<UserRole> getUserRoleList() {
        List<UserRole> temp = new ArrayList<>();

        int tempDrawable = R.drawable.ic_outline_cancel_presentation_24;
        temp.add(new UserRole(tempDrawable, "Employee", false));
        temp.add(new UserRole(tempDrawable, "Manager", false));
        temp.add(new UserRole(tempDrawable, "Office Boy", false));
        temp.add(new UserRole(tempDrawable, "HR", false));
        temp.add(new UserRole(tempDrawable, "KPA", false));
        temp.add(new UserRole(tempDrawable, "MOU", false));

        return temp;
    }

    private void setUpRecyclerView(List<UserRole> list)
    {
        adapter = new LoginCredentialsAdapter(this, list);
        mBinding.rvRoleTodo.setAdapter(adapter);
    }

    @Override
    protected void clicks()
    {
        mBinding.loginBtnTodo.setOnClickListener(view ->{
            String email = mBinding.etEmailTodo.getText().toString().trim();
            String pwd = mBinding.etPwdTodo.getText().toString().trim();

            Log.d("TAG", "clicks: "+email);
            if(isNotEmpty(email, pwd))
            {
                viewModel.saveDataToLiveData(new LoginCredentials(email, pwd, null));
                startActivity(new Intent(TodoMainActivity.this, TodoHomeActivity.class));
                finish();
            }
        } );
    }

    private boolean isNotEmpty(String email, String pwd) {
        Log.d("TAG", "isNotEmpty: "+email);
        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(pwd))
        {
            mBinding.etEmailTodo.setError("Field Required");
            mBinding.etPwdTodo.setError("Field Required");
            return false;
        }
        else
            return true;

    }
}