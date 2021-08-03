package com.example.totalapplecount.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.totalapplecount.Interface.CommunicationListener;
import com.example.totalapplecount.MainActivity;
import com.example.totalapplecount.R;

public class TotalApplesFragment extends Fragment {

    private EditText mEtTotalApple;
    private TextView mTvApples;
    private Button mBtnNext;
    private CommunicationListener communicationListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d("Fra", "onAttach");
        communicationListener = (CommunicationListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("Fra", "onCreateView");
        return inflater.inflate(R.layout.fragment_total_apples, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("Fra", "onViewCreated");
        initViews(view);
        Bundle bundle = getArguments();
        if (bundle != null) {
            int data = bundle.getInt("req");
            mTvApples.setText(data + "");
        }
    }


    private void initViews(View view) {
        mEtTotalApple = view.findViewById(R.id.etTotalApple);
        mTvApples = view.findViewById(R.id.tvTotalApple);
        mBtnNext = view.findViewById(R.id.btnNext);

        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                int no = Integer.parseInt(mEtTotalApple.getText().toString());
                bundle.putInt("noOfApple", no);
                communicationListener.listener(bundle, "totalApplesFragment");
            }
        });
    }

}