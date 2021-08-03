package com.example.events;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class PreviewActivity extends AppCompatActivity {

    private TextView mTvTitle;
    private TextView mTvDesc;
    private TextView mTvStartDate;
    private TextView mTvEndDate;
    private TextView mTvStartTime;
    private TextView mTvEndTime;
    private TextView mTvPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        initViews();
        getValueFromIntent();
    }

    private void getValueFromIntent() {
        Model model = (Model) getIntent().getSerializableExtra("model");
        mTvTitle.setText(model.getTitle());
        mTvDesc.setText(model.getDesc());
        mTvStartDate.setText(model.getStartDate());
        mTvEndDate.setText(model.getEndDate());
        mTvStartTime.setText(model.getStartTime());
        mTvEndTime.setText(model.getEndTime());
        mTvPrice.setText(model.getPrice());
    }

    private void initViews() {
        mTvTitle = findViewById(R.id.tvEventTitle);
        mTvDesc = findViewById(R.id.tvEventDesc);
        mTvStartDate = findViewById(R.id.tvEventStartDate);
        mTvEndDate = findViewById(R.id.tvEventEndDate);
        mTvStartTime = findViewById(R.id.tvEventStartTime);
        mTvEndTime = findViewById(R.id.tvEventEndTime);
        mTvPrice = findViewById(R.id.tvEventPrice);
    }
}