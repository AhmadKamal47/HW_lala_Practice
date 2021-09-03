package com.example.hwlalapractice.apps.TestingAPIs.repository.db.remoteDB.api;

import com.example.hwlalapractice.apps.TestingAPIs.repository.db.remoteDB.client.PostClient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRemoteAPI{

    private final Retrofit retrofit;

    private static RetrofitRemoteAPI instance;

    public static RetrofitRemoteAPI getInstance()
    {
        if(instance == null)
        {
            instance = new RetrofitRemoteAPI();
        }
        return instance;
    }

    private RetrofitRemoteAPI() {
        retrofit = new Retrofit
                .Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public PostClient initPostClient()
    {
        return retrofit.create(PostClient.class);
    }
}
