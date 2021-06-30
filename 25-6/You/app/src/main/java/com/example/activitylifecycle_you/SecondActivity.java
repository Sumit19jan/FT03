package com.example.activitylifecycle_you;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    private Button mBtnLaunchThird;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mBtnLaunchThird = findViewById(R.id.btnLaunchThird);
        mBtnLaunchThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent1);
            }
        });
        Log.d("Tag", "onCreate2");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Tag", "onStart2");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Tag", "onResume2");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Tag", "onPause2");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Tag", "onStop2");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Tag", "onDestroy2");

    }
}