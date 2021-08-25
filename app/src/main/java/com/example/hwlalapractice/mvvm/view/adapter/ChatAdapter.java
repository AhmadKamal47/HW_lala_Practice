package com.example.hwlalapractice.mvvm.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hwlalapractice.databinding.ItemChatBinding;
import com.example.hwlalapractice.mvvm.repository.model.Chat;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MyViewHolder> {
    private Context context;
    private List<Chat> chatList;
    private ItemChatBinding mItemBinding;

    public ChatAdapter(Context context, List<Chat> chatList) {
        this.context = context;
        this.chatList = chatList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mItemBinding = ItemChatBinding.inflate(LayoutInflater.from(context), parent, false);
        return new MyViewHolder(mItemBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.setIsRecyclable(false);
        Chat chat = chatList.get(position);

        mItemBinding.nameTv.setText(chat.getName());
        mItemBinding.msgTv.setText(chat.getLastMessage());
        mItemBinding.totalMsgTv.setText(String.valueOf(chat.getTotalMessages()));

        mItemBinding.profileIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }

    // inner Class
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
