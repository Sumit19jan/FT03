package com.example.sprint_4_evaluation;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CovidResultsViewHolder extends RecyclerView.ViewHolder {

    private TextView mTvDate;
    private TextView mTvPositive;
    private TextView mTvNegative;
    private TextView mTvHospitalizedCurrently;
    private TextView mTvOnVentilatorCurrently;
    private TextView mTvDeath;
    private TextView mTvDateChecked;
    private CardView mCardView;
    private OnItemClicked onItemClicked;

    public CovidResultsViewHolder(@NonNull View itemView, OnItemClicked onItemClicked) {
        super(itemView);
        this.onItemClicked = onItemClicked;
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mTvDate = itemView.findViewById(R.id.tvDate);
        mTvPositive = itemView.findViewById(R.id.tvPositive);
        mTvNegative = itemView.findViewById(R.id.tvNegative);
        mTvHospitalizedCurrently = itemView.findViewById(R.id.tvHospitalizedCurrently);
        mTvOnVentilatorCurrently = itemView.findViewById(R.id.tvOnVentilatorCurrently);
        mTvDeath = itemView.findViewById(R.id.tvDeath);
        mTvDateChecked = itemView.findViewById(R.id.tvDateChecked);
        mCardView = itemView.findViewById(R.id.cardView);
        mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClicked.onClicked();
            }
        });

    }

    public void setData(ResponseModel responseModel) {
        mTvDate.setText(responseModel.getDate() + "");
        mTvPositive.setText(responseModel.getPositive() + "");
        mTvNegative.setText(responseModel.getNegative() + "");
        mTvHospitalizedCurrently.setText(responseModel.getHospitalizedCurrently() + "");
        mTvOnVentilatorCurrently.setText(responseModel.getOnVentilatorCurrently() + "");
        mTvDeath.setText(responseModel.getDeath() + "");
        android.text.format.DateFormat df = new android.text.format.DateFormat();
        df.format(mTvDate.getText().toString(), new java.util.Date());


      //  mTvDateChecked.setText(responseModel.getDateChecked() + "");
    }




}
