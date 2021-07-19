package com.example.sprint_4_evaluation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeScreen extends AppCompatActivity implements OnItemClicked {

    private RecyclerView recyclerView;
    private List<ResponseModel> responseModelList = new ArrayList<>();
    private CovidResultAdapter covidResultAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        initViews();
        callApi();
    }

    private void callApi() {
        ApiService apiService = NetworkClass.getInstance().create(ApiService.class);
        apiService.getCovidResult().enqueue(new Callback<List<ResponseModel>>() {
            @Override
            public void onResponse(Call<List<ResponseModel>> call, Response<List<ResponseModel>> response) {
                if (response.code() == 200 && response.body() != null) {
                    responseModelList = response.body();
                    setRecycler();
                }
            }

            @Override
            public void onFailure(Call<List<ResponseModel>> call, Throwable t) {

            }
        });
    }

    private void setRecycler() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(HomeScreen.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        covidResultAdapter = new CovidResultAdapter(responseModelList, this);
        recyclerView.setAdapter(covidResultAdapter);
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
    }

    @Override
    public void onLongClicked() {
        covidResultAdapter.updateAdapter(responseModelList);
    }

    @Override
    public void onClicked() {
        Intent intent = new Intent(HomeScreen.this, WebViewActivity.class);
        startActivity(intent);
    }
}