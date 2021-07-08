package com.example.recyclerview_itemclick;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentViewHolder extends RecyclerView.ViewHolder {

    private ImageView mIvStudentImage;
    private TextView mTvName;
    private TextView mTvAge;
    private TextView mTvDob;
    private TextView mTvAddress;
    private RelativeLayout relativeLayout;
    private ItemClickListener itemClickListener;

    public StudentViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mIvStudentImage = itemView.findViewById(R.id.ivStudentImage);
        mTvName = itemView.findViewById(R.id.tvName);
        mTvAge = itemView.findViewById(R.id.tvAge);
        mTvDob = itemView.findViewById(R.id.tvDob);
        mTvAddress = itemView.findViewById(R.id.tvAddress);
        relativeLayout = itemView.findViewById(R.id.relativeLayout);
    }

    public void setData(StudentModel studentModel) {
        mIvStudentImage.setImageResource(studentModel.getImageId());
        mTvName.setText(studentModel.getName());
        mTvAge.setText(studentModel.getAge() + "");
        mTvDob.setText(studentModel.getDob());
        mTvAddress.setText(studentModel.getAddress());
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClicked(studentModel,getAdapterPosition());
            }
        });
    }
}
