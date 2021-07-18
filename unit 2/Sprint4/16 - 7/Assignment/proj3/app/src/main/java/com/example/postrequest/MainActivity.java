package com.example.postrequest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button mBtnCallApi;
    private EditText mEtEmail;
    private EditText mEtPassword;
    private EditText mEtTitle;
    private EditText mEtRequestType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mEtEmail = findViewById(R.id.etEmail);
        mEtPassword = findViewById(R.id.etPassword);
        mEtTitle = findViewById(R.id.etTitle);
        mEtRequestType = findViewById(R.id.etRequestType);
        mBtnCallApi = findViewById(R.id.btnCallApi);
        mBtnCallApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callApi();
            }
        });
    }

    private void callApi() {
        ApiService apiService = NetworkClass.getInstance().create(ApiService.class);
        String email = mEtEmail.getText().toString();
        String password = mEtPassword.getText().toString();
        String title = mEtTitle.getText().toString();
        String requestType = mEtRequestType.getText().toString();
        RequestModel requestModel = new RequestModel(email,password,title,requestType);
        apiService.getPost(requestModel).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if (response.code() == 201 && response.body() != null) {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("title" ,response.body().getTitle());
                    intent.putExtra("email", response.body().getEmail());
                    intent.putExtra("requestType" , response.body().getRequestType());
                    intent.putExtra("id", response.body().getId());
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });
    }
}