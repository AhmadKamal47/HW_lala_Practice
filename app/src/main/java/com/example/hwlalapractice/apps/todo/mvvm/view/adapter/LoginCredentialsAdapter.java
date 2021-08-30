package com.example.hwlalapractice.apps.todo.mvvm.view.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hwlalapractice.R;
import com.example.hwlalapractice.apps.todo.mvvm.repository.model.LoginCredentials;
import com.example.hwlalapractice.apps.todo.mvvm.repository.model.UserRole;
import com.example.hwlalapractice.databinding.ItemDrawableRolesBinding;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class LoginCredentialsAdapter extends RecyclerView.Adapter<LoginCredentialsAdapter.MyViewHolder> {

    private ItemDrawableRolesBinding binding;
    private Context context;
    private List<UserRole> list;
    private UserRole role;


    public LoginCredentialsAdapter(Context context, List<UserRole> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public LoginCredentialsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemDrawableRolesBinding.inflate(LayoutInflater.from(context), parent, false);
        return new MyViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull LoginCredentialsAdapter.MyViewHolder holder, int position) {

    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
