package com.example.hwlalapractice.apps.todo.mvvm.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hwlalapractice.apps.todo.mvvm.repository.model.UserWithCNIC;
import com.example.hwlalapractice.databinding.ItemChatBinding;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private final Context context;
    private List<UserWithCNIC> list;

    public void setList(List<UserWithCNIC> userList) {
        list = userList;
        this.notifyDataSetChanged();
    }

    public UserAdapter(Context context) {
        this.context = context;
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

        long id = list.get(position).getUser().getId();
        String name = list.get(position).getUser().getName();
        String address = list.get(position).getUser().getAddress();
        String cnic = list.get(position).getCnic().getCnic_no();

        itemChatBinding.totalMsgTv.setText(String.valueOf(id));
        itemChatBinding.nameTv.setText(name);
        itemChatBinding.msgTv.setText(address);
        itemChatBinding.cnic.setText(cnic);
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
