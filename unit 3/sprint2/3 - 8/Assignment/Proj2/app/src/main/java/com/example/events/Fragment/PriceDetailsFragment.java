package com.example.events.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.events.Model;
import com.example.events.PreviewActivity;
import com.example.events.R;

public class PriceDetailsFragment extends Fragment {

    private EditText mEtCurrency;
    private EditText mEtPrice;
    private Button mBtnPreview;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_price_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        iniViews(view);
    }

    private void iniViews(View view) {
        mEtCurrency = view.findViewById(R.id.etCurrency);
        mEtPrice = view.findViewById(R.id.etPrice);
        mBtnPreview = view.findViewById(R.id.btnPreviewActivity);
        mBtnPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = getArguments();
                String title = bundle.getString("title");
                String desc = bundle.getString("desc");
                String startDate = bundle.getString("startDate");
                String endDate = bundle.getString("endDate");
                String startTime = bundle.getString("startTime");
                String endTime = bundle.getString("endTime");
                String price = mEtPrice.getText().toString();
                Intent intent = new Intent(getContext(), PreviewActivity.class);
                Model model = new Model(title, desc, startDate, endDate, startTime, endTime, price);
                intent.putExtra("model", model);
                startActivity(intent);

            }
        });
    }
}