package com.example.hwlalapractice.apps.TestingDB.mvvm.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hwlalapractice.apps.TestingAPIs.repository.model.Post;
import com.example.hwlalapractice.databinding.ItemChatBinding;

import java.util.List;

public class SomeAdapter extends BaseAdapter<ItemChatBinding, Post>{

    public SomeAdapter(List<Post> mItemList, Context context) {
        super(mItemList, context);
    }

    @Override
    protected ItemChatBinding initBindingRef(LayoutInflater inflater, ViewGroup parent) {
        return ItemChatBinding.inflate(inflater, parent, false);
    }

    @Override
    protected View initRoot() {
        return mItemBinding.getRoot();
    }

    @Override
    protected void bindItems(int position) {
    }
}
