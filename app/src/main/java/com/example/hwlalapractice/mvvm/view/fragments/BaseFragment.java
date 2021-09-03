package com.example.hwlalapractice.mvvm.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment<VB> extends Fragment {

    protected VB mBinding;

    public BaseFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = initBindingRef(inflater, container, false);
        return initRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRef(view);
        clicks();
    }

    protected abstract VB initBindingRef(LayoutInflater inflater, ViewGroup container, Boolean attatchToParent);
    protected abstract View initRoot();
    protected abstract void initRef(View view);
    protected abstract void clicks();
}
