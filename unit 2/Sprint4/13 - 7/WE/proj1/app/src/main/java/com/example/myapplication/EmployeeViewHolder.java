package com.example.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EmployeeViewHolder extends RecyclerView.ViewHolder {

    private TextView mTvName;
    private TextView mTvAge;
    private TextView mTvAddress;
    private ImageView mIvEdit;
    private ItemClickListener itemClickListener;

    public EmployeeViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
        initData(itemView);
    }

    private void initData(View itemView) {
        mTvName = itemView.findViewById(R.id.tvName);
        mTvAddress = itemView.findViewById(R.id.tvAddress);
        mTvAge = itemView.findViewById(R.id.tvAge);
        mIvEdit = itemView.findViewById(R.id.ivEdit);
    }

    public void setData(Employee employee) {
        mTvName.setText(employee.getName());
        mTvAge.setText(String.valueOf(employee.getAge()));
        mTvAddress.setText(employee.getAddress());
        mIvEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClicked(getAdapterPosition(), employee);
            }
        });
    }
}
