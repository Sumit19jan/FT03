package com.example.getresourcesapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecondActivity extends AppCompatActivity {

    private TextView mTvName;
    private TextView mTvYear;
    private CardView mCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();
        getValueFromIntent();
    }

    private void getValueFromIntent() {
        Intent intent = getIntent();
        int id = Integer.parseInt(intent.getStringExtra("Id"));
        callApi(id);
    }

    private void callApi(int id) {
        ApiService apiService = NetworkClass.getInstance().create(ApiService.class);
        apiService.getDetails(id).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if (response.code() == 200 && response.body() != null) {
                    mTvName.setText(response.body().getData().getName());
                    mTvYear.setText(response.body().getData().getYear() + "");
      //              mCardView.setBackgroundColor(Integer.parseInt(response.body().getData().getColor().toString()));

                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });
    }

    private void initViews() {
        mTvName = findViewById(R.id.tvName);
        mTvYear = findViewById(R.id.tvYear);
        mCardView = findViewById(R.id.cardView);
    }
}