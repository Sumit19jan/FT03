package com.example.retrofit_we;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText mEtUserId;
    private Button mBtnCallApi;
    private TextView mTvFirstName;
    private TextView mTvLastName;
    private TextView mTvEmail;
    private ImageView mIvAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mEtUserId = findViewById(R.id.etUserId);
        mBtnCallApi = findViewById(R.id.btnCallAPI);
        mTvFirstName = findViewById(R.id.tvFirstName);
        mTvLastName = findViewById(R.id.tvLastName);
        mTvEmail = findViewById(R.id.tvEmail);
        mIvAvatar = findViewById(R.id.ivAvatar);

        mBtnCallApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callApi();
            }
        });
    }

    private void callApi() {
        ApiService apiService = Network.getInstance().create(ApiService.class);
        int id = Integer.parseInt(mEtUserId.getText().toString());
        apiService.getUser(id).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {

                if (response.body() != null) {
                    ResponseModel model = response.body();
                    mTvFirstName.setText(model.getData().getFirstName());
                    mTvLastName.setText(model.getData().getLastName());
                    mTvEmail.setText(model.getData().getEmail());
                    Glide.with(mIvAvatar).load(model.getData().getAvatar()).into(mIvAvatar);
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });
    }
}