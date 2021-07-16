package com.example.inshortsnewsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText mEtCategory;
    private Button mBtnCallAPi;
    private RecyclerView mRecyclerView;
    private List<DataModel> dataModelList = new ArrayList<>();
    private DataAdapter dataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void callApi() {
        ApiService apiService = Network.getInstance().create(ApiService.class);
        String category = mEtCategory.getText().toString();
        apiService.getDataFromResponse(category).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if (response.code() == 200 && response.body() != null) {
                    dataModelList = response.body().getData();
                    setRecycler();
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });
    }

    private void setRecycler() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        dataAdapter = new DataAdapter(dataModelList);
        mRecyclerView.setAdapter(dataAdapter);
    }

    private void initViews() {
        mEtCategory = findViewById(R.id.etCategory);
        mRecyclerView = findViewById(R.id.recyclerView);
        mBtnCallAPi = findViewById(R.id.btnCallApi);
        mBtnCallAPi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callApi();
            }
        });
    }
}