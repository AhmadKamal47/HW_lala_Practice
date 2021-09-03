package com.example.hwlalapractice.apps.todo.mvvm.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hwlalapractice.R;
import com.example.hwlalapractice.databinding.FragmentHomeBinding;
import com.example.hwlalapractice.mvvm.view.fragments.BaseFragment;

public class HomeFragment extends BaseFragment<FragmentHomeBinding> {

    @Override
    protected FragmentHomeBinding initBindingRef(LayoutInflater inflater, ViewGroup container, Boolean attatchToParent) {
        return FragmentHomeBinding.inflate(inflater, container, attatchToParent);
    }

    @Override
    protected View initRoot() {
        return mBinding.getRoot();
    }

    @Override
    protected void initRef(View view) {

    }

    @Override
    protected void clicks() {

    }

}