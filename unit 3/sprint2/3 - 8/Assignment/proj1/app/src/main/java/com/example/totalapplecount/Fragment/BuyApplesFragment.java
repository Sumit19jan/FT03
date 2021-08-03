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

import com.example.totalapplecount.Interface.CommunicationListener;
import com.example.totalapplecount.R;


public class BuyApplesFragment extends Fragment {

    private Button mBtnBack;
    private EditText mEtNoOfApple;
    private CommunicationListener communicationListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Fra", "onCreateB");
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d("Fra", "onAttachB");
        communicationListener = (CommunicationListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("Fra", "onCreateViewB");
        return inflater.inflate(R.layout.fragment_buy_apples, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("Fra", "onViewCreatedB");
        initViews(view);
    }

    private void initViews(View view) {
        mEtNoOfApple = view.findViewById(R.id.etNoOfAppleBuy);
        mBtnBack = view.findViewById(R.id.btnBack);
        mBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle1 = getArguments();
                int total = bundle1.getInt("noOfApple");
                int req = Integer.parseInt(mEtNoOfApple.getText().toString());
                Bundle bundle = new Bundle();
                if (req <= total) {
                    int req1 = total - req;
                    bundle.putInt("req", req1);
                } else {
                    mEtNoOfApple.setError("Invalid Quantity");
                }
                communicationListener.listener(bundle, "buyApplesFragment");
            }
        });
    }

}