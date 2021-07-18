package com.example.postrequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {

    @POST("posts")
    Call<ResponseModel> getPost(@Body RequestModel requestModel);
}
