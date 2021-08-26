package com.example.hwlalapractice.apps.todo.mvvm.view.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        binding.roleTv.setText(list.get(position).getName());
        binding.rvIv.setImageResource(list.get(position).getIcon());

        list.get(position).setSelected(true);

        binding.getRoot().setOnClickListener(view -> {
            UserRole role = list.get(position);
            if(role.isSelected())
            {
                holder.itemView.setBackgroundColor(Color.YELLOW);
                role.setSelected(false);
            }
            else if(!role.isSelected())
            {
                holder.itemView.setBackgroundColor(Color.WHITE);
                role.setSelected(true);
            }
            Log.d("TAG", "ItemSelected: " + position + " " + role.getName() );
//            binding.getRoot().setBackgroundColor(role.isSelected()? Color.YELLOW: Color.WHITE);

        });
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
