package com.example.eventlistenerssaveuistates;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mEtEdit;
    private TextView mTvText;
    private Button mBtButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewsAndListeners();
    }

    private void initViewsAndListeners() {

        mEtEdit = findViewById(R.id.etEdit);
        mTvText = findViewById(R.id.tvText);
        mBtButton = findViewById(R.id.btnButton);

        if (mEtEdit.getText().toString().length() >= 6) {
            Toast.makeText(MainActivity.this,mEtEdit.getText().toString(),Toast.LENGTH_SHORT).show();
        }

        mBtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvText.setText("ButtonClicked");
            }
        });

    }

}