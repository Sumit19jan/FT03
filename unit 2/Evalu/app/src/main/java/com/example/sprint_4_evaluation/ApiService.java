package com.example.sprint_4_evaluation;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("v1/us/daily.json")
    Call<List<ResponseModel>> getCovidResult();
}
