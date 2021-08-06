package com.example.itunesapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

   @GET("search")
    Call<ResponseModel> getTune(@Query("term") String term);
}
