package com.example.hwlalapractice.mvvm.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.hwlalapractice.apps.todo.mvvm.view.activity.TodoMainActivity;
import com.example.hwlalapractice.databinding.ActivityMainBinding;
import com.example.hwlalapractice.mvvm.repository.model.Chat;
import com.example.hwlalapractice.mvvm.view.adapter.ChatAdapter;
import com.example.hwlalapractice.mvvm.viewmodel.ChatViewModel;

import java.util.List;
import java.util.Random;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    private ChatViewModel mChatViewModel;

    @Override
    public ActivityMainBinding initBindingRef() {
        return ActivityMainBinding.inflate(getLayoutInflater());
    }

    @Override
    protected View initRoot() {
        return mBinding.getRoot();
    }

    @Override
    protected void initRef()
    {
        mChatViewModel = new ViewModelProvider(this).get(ChatViewModel.class);
        observeChatList();
        clicks();
    }

    @Override
    protected void clicks() {
        mBinding.refreshChatsBtn.setOnClickListener(view -> mChatViewModel.getChatList(new Random().nextInt(100)));
        mBinding.todoAppBtn.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, TodoMainActivity.class)));
    }

    private void observeChatList() {
        mChatViewModel.getChatListLiveData().observe(this, chats -> {
            if (chats != null && chats.size() > 0)
                setUpRecyclerView(chats);
        });
    }

    private void setUpRecyclerView(List<Chat> list) {
        ChatAdapter adapter = new ChatAdapter(this, list);
        mBinding.recyclerView.setAdapter(adapter);
        mBinding.recyclerView.setHasFixedSize(true);
    }
}