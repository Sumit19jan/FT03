package com.example.activitylifecycle_you;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Log.d("Tag", "onCreate3");

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Tag", "onStart3");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Tag", "onResume3");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Tag", "onPause3");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Tag", "onStop3");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Tag", "onDestroy3");

    }
}