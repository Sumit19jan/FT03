package com.example.retrofit2_we;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText mEtPostId;
    private Button mBtnFetch;
    private RecyclerView recyclerView;
    private List<ResponseModel> responseModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }

    private void callApi() {
        ApiService apiService = Network.getInstance().create(ApiService.class);
        int PostId = Integer.parseInt(mEtPostId.getText().toString());
        apiService.getPost(PostId).enqueue(new Callback<List<ResponseModel>>() {
            @Override
            public void onResponse(Call<List<ResponseModel>> call, Response<List<ResponseModel>> response) {
                if (response.body() != null) {
                    responseModelList = response.body();
                    setRecyclerViews();
                }
            }

            @Override
            public void onFailure(Call<List<ResponseModel>> call, Throwable t) {

            }
        });
    }

    private void setRecyclerViews() {
        PostAdapter postAdapter = new PostAdapter(responseModelList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this , 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(postAdapter);
    }

    private void initViews() {
        mEtPostId = findViewById(R.id.etPostId);
        mBtnFetch = findViewById(R.id.btnFetch);
        recyclerView = findViewById(R.id.recyclerView);
        mBtnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callApi();
            }
        });
    }
}