package com.example.hwlalapractice.apps.TestingAPIs.view.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hwlalapractice.apps.TestingAPIs.repository.model.Post;
import com.example.hwlalapractice.databinding.ItemPostsBinding;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder> {

    ItemPostsBinding itemPostsBinding;
    List<Post> list;
    Context context;

    public PostAdapter(Context context, List<Post> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemPostsBinding = ItemPostsBinding.inflate(LayoutInflater.from(context), parent, false);
        return new MyViewHolder(itemPostsBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        long id = list.get(position).getId();
        long userid = list.get(position).getUserId();
        String title = list.get(position).getTitle();
        String body = list.get(position).getBody();

        itemPostsBinding.tvIdTestingApi.setText(String.valueOf(id));
        itemPostsBinding.tvUserIdTestingApi.setText(String.valueOf(userid));
        itemPostsBinding.tvTitleTestingApi.setText(title);
        itemPostsBinding.tvBodyTestingApi.setText(body);
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
