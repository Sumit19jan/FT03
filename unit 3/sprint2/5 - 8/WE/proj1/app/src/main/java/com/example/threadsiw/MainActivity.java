package com.example.threadsiw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mBtnTaskOne;
    private Button mBtnTaskTwo;
    private WorkerThread workerThread;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        workerThread = new WorkerThread();
        workerThread.start();
        initViews();
    }

    private void initViews() {
        mBtnTaskOne = findViewById(R.id.btnTaskOne);
        mBtnTaskTwo = findViewById(R.id.btnTaskTwo);

        mBtnTaskOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workerThread.addTaskToQueue(taskOne);
            }
        });

        mBtnTaskTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workerThread.addTaskToQueue(taskTwo);
            }
        });

    }

    private Runnable taskOne = new Runnable() {
        @Override
        public void run() {
            Log.d(TAG,"TASK ONE" + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    private Runnable taskTwo  = new Runnable() {
        @Override
        public void run() {
            Log.d(TAG,"TASK TWO" + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
}