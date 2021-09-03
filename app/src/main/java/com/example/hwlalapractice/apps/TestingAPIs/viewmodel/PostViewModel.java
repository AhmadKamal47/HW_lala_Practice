package com.example.hwlalapractice.apps.TestingAPIs.viewmodel;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hwlalapractice.apps.TestingAPIs.repository.db.remoteDB.api.RetrofitRemoteAPI;
import com.example.hwlalapractice.apps.TestingAPIs.repository.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {
    MutableLiveData<List<Post>> listMutableLiveData;

    public PostViewModel() {}

    public MutableLiveData<List<Post>> getListMutableLiveData() {
        if(listMutableLiveData == null){
            listMutableLiveData = new MutableLiveData<>();
            fetchAllPosts();
        }
        return listMutableLiveData;
    }

    public void fetchAllPosts()
    {
        RetrofitRemoteAPI
                .getInstance()
                .initPostClient()
                .getAllPosts()
                .enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                try
                {
                    Log.d("TAG", "onResponse_: "+response);
                    Log.d("TAG", "onResponse_Code: "+response.code());
                    Log.d("TAG", "onResponse_Body: "+response.body());
                    if(response.code() == 200)
                        listMutableLiveData.setValue(response.body());
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.e("TAG", "onFailure: "+t.getMessage());
            }
        });
    }
}
