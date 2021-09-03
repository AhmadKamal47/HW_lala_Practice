package com.example.hwlalapractice.apps.todo.mvvm.view.activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.example.hwlalapractice.apps.todo.mvvm.repository.db.roomDB.entity.User;
import com.example.hwlalapractice.apps.todo.mvvm.repository.model.UserWithCNIC;
import com.example.hwlalapractice.apps.todo.mvvm.view.adapter.UserAdapter;
import com.example.hwlalapractice.apps.todo.mvvm.viewmodel.UserViewModel;
import com.example.hwlalapractice.databinding.ActivityTodoHomeBinding;
import com.example.hwlalapractice.mvvm.view.activity.BaseActivity;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class TodoHomeActivity extends BaseActivity<ActivityTodoHomeBinding> {

    private UserViewModel viewModel;
    private UserAdapter adapter;
    private List<UserWithCNIC> list;

    @Override
    protected ActivityTodoHomeBinding initBindingRef() {
        return ActivityTodoHomeBinding.inflate(getLayoutInflater());
    }

    @Override
    protected View initRoot()
    {
        return mBinding.getRoot();
    }

    @Override
    protected void initRef()
    {
        viewModel = new ViewModelProvider(this).get(UserViewModel.class);
        viewModel.fetchData();
        adapter = new UserAdapter(this);
        list = new ArrayList<>();
        setRecyclerViewList(list);
        observeLiveData();
    }


    private void observeLiveData() {
        viewModel.getListMutableLiveData().observe(this, new Observer<List<UserWithCNIC>>() {
            @Override
            public void onChanged(List<UserWithCNIC> users) {
                list.clear();
                list.addAll(users);
            }
        });

    }

    private void setRecyclerViewList(List<UserWithCNIC> userList) {
        adapter.setList(list);
        mBinding.rvUserInfoTodoHome.setAdapter(adapter);
    }


    @Override
    protected void clicks() {
        mBinding.addBtnTodoHome.setOnClickListener(view -> {
            String name = mBinding.etNameTodoHome.getText().toString().trim();
            String address = mBinding.etAddressTodoHome.getText().toString().trim();
            String cnic = mBinding.etCnicTodoHome.getText().toString().trim();

            if (TextUtils.isEmpty(name)) {
                mBinding.etNameTodoHome.setError("Required Field...");
                return;
            }
            if (TextUtils.isEmpty(address)) {
                mBinding.etAddressTodoHome.setError("Required Field...");
                return;
            }
            if (TextUtils.isEmpty(cnic)) {
                mBinding.etCnicTodoHome.setError("Required Field...");
                return;
            }
            viewModel.saveData(new User(name, address, Long.parseLong(cnic)));

        });
    }


}