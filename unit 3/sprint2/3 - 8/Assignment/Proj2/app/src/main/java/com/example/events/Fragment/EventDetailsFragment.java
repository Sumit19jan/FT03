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

public class EventDetailsFragment extends Fragment {

    private EditText mEtEventTitle;
    private EditText mEtEventDescription;
    private Button mBtnTimeAndDateFragment;
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
        return inflater.inflate(R.layout.fragment_event_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        mEtEventTitle = view.findViewById(R.id.etEventTitle);
        mEtEventDescription = view.findViewById(R.id.etEventDescription);
        mBtnTimeAndDateFragment = view.findViewById(R.id.btnTimeAndDateFragment);
        mBtnTimeAndDateFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("title", mEtEventTitle.getText().toString());
                bundle.putString("desc", mEtEventDescription.getText().toString());
                communicationListener.listener(bundle, "eventDetailsFragment");
            }
        });
    }
}