package com.example.hwlalapractice.apps.TestingAPIs.view.activity;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.hwlalapractice.apps.TestingAPIs.repository.model.Post;
import com.example.hwlalapractice.apps.TestingAPIs.view.adapters.PostAdapter;
import com.example.hwlalapractice.apps.TestingAPIs.viewmodel.PostViewModel;
import com.example.hwlalapractice.databinding.ActivityMainTestingApiBinding;
import com.example.hwlalapractice.mvvm.view.activity.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivityTestingApi extends BaseActivity<ActivityMainTestingApiBinding> {

    private PostViewModel postViewModel;
    private PostAdapter postAdapter;
    private List<Post> list;

    @Override
    protected View initRoot() {
        return mBinding.getRoot();
    }

    @Override
    protected ActivityMainTestingApiBinding initBindingRef() {
        return ActivityMainTestingApiBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initRef() {

        list = new ArrayList<>();
        postAdapter = new PostAdapter(this, list);
        mBinding.rvPostTestingApi.setHasFixedSize(true);
        mBinding.rvPostTestingApi.setAdapter(postAdapter);

        postViewModel = new ViewModelProvider(this).get(PostViewModel.class);
        observeLiveData();
    }

    private void observeLiveData() {
        postViewModel.getListMutableLiveData().observe(this, new Observer<List<Post>>() {
            @Override
            public void onChanged(List<Post> posts) {
                Log.d("TAG", "onChanged_List: "+posts);
                if(posts != null)
                    Log.d("TAG", "onChanged_List_Size: "+posts.size());
                setRecyclerView(posts);
            }
        });
    }

    private void setRecyclerView(List<Post> posts) {
        list.clear();
        list.addAll(posts);
        postAdapter.notifyDataSetChanged();

        mBinding.tvTotalPosts.setText("total posts found: " + posts.size());
    }

    @Override
    protected void clicks() {

    }
}