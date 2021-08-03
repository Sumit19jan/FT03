package com.example.events.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.events.Interface.CommunicationListener;
import com.example.events.R;


public class TimeAndDateFragment extends Fragment {

    private EditText mEtStartDate;
    private EditText mEtEndDate;
    private EditText mEtStartTime;
    private EditText mEtEndTime;
    private Button PriceDetailsFragment;
    private CommunicationListener communicationListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        communicationListener = (CommunicationListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_time_and_date, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        mEtStartDate = view.findViewById(R.id.etEventStartDate);
        mEtEndDate = view.findViewById(R.id.etEventEndDate);
        mEtStartTime = view.findViewById(R.id.etEventStartTime);
        mEtEndTime = view.findViewById(R.id.etEventEndTime);
        PriceDetailsFragment = view.findViewById(R.id.btnPriceDetailsFragment);
        PriceDetailsFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("startDate", mEtStartDate.getText().toString());
                bundle.putString("endDate", mEtEndDate.getText().toString());
                bundle.putString("startTime", mEtStartTime.getText().toString());
                bundle.putString("endTime", mEtEndTime.getText().toString());
                communicationListener.listener(bundle, "timeAndDateFragment");
            }
        });
    }
}