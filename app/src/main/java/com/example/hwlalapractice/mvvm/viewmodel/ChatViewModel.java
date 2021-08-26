package com.example.hwlalapractice.mvvm.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hwlalapractice.mvvm.repository.model.Chat;

import java.util.ArrayList;
import java.util.List;

public class ChatViewModel extends ViewModel {

    private final MutableLiveData<List<Chat>> mChatListLiveData;

    public ChatViewModel() {
        mChatListLiveData = new MutableLiveData<>();
        getChatList(5);
    }

    public MutableLiveData<List<Chat>> getChatListLiveData() {
        return mChatListLiveData;
    }


    public void getChatList(int max) {
        List<Chat> list = new ArrayList<>();

        for (int i = 0; i < max; i++) {
            String name = "Name " + i;
            String msg = "Kamal No. " + i;
            int total = 3 * (i + 1);
            Chat chat = new Chat(name, msg, total);
            list.add(chat);
        }

        mChatListLiveData.setValue(list);
    }
}
