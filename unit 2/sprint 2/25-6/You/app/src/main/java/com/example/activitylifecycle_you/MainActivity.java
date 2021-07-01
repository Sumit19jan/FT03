package com.example.activitylifecycle_you;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mBtnLaunchSecond;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnLaunchSecond = findViewById(R.id.btnLaunchSecond);
        mBtnLaunchSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
        Log.d("Tag", "onCreate1");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Tag", "onStart1");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Tag", "onResume1");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Tag", "onPause1");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Tag", "onStop1");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Tag", "onDestroy1");

    }
}