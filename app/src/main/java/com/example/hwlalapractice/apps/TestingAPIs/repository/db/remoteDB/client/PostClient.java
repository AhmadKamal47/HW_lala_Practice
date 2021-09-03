package com.example.hwlalapractice.apps.TestingAPIs.repository.db.remoteDB.client;



import com.example.hwlalapractice.apps.TestingAPIs.repository.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostClient {

    @GET("posts")
    Call<List<Post>> getAllPosts();

}
