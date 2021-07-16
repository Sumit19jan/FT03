package com.example.inshortsnewsapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("news")
     Call<ResponseModel> getDataFromResponse(@Query("category") String category);
}
