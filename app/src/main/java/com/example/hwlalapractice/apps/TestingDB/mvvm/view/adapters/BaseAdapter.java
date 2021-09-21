package com.example.hwlalapractice.apps.TestingDB.mvvm.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public abstract class BaseAdapter<VB, T> extends RecyclerView.Adapter<BaseAdapter.MyViewHolder> {

    protected Context context;
    protected List<T> mItemList;
    protected VB mItemBinding;

    protected abstract VB initBindingRef(LayoutInflater inflater, ViewGroup parent);
    protected abstract View initRoot();
    protected abstract void bindItems(int position);


    public BaseAdapter(List<T> mItemList, Context context) {
        this.mItemList = mItemList;
        this.context = context;
    }

    public BaseAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mItemBinding = initBindingRef(LayoutInflater.from(context), parent);
        return new MyViewHolder(initRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        bindItems(position);
    }


    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
