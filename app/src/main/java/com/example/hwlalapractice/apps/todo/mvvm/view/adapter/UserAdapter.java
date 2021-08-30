package com.example.hwlalapractice.apps.todo.mvvm.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hwlalapractice.apps.todo.mvvm.repository.model.User;
import com.example.hwlalapractice.databinding.ItemChatBinding;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private final Context context;
    private List<User> list;

    public UserAdapter(Context context, List<User> list) {
        this.context = context;
        this.list = list;
    }

    ItemChatBinding itemChatBinding;
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemChatBinding = ItemChatBinding.inflate(LayoutInflater.from(context), parent, false );
        return new UserViewHolder(itemChatBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder{

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
