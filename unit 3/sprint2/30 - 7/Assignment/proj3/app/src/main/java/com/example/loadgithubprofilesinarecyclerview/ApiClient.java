package com.example.loadgithubprofilesinarecyclerview;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiClient {

    @GET("users/{user}/repos")
    Call<List<ResponseModel>> getUser(@Path("user") String user);
}
