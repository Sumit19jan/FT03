package com.example.recyclerview_we;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class StudentViewHolder extends RecyclerView.ViewHolder {

    private TextView mTvName;
    private TextView mTvAge;
    private TextView mTvRollNo;

    public StudentViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mTvName = itemView.findViewById(R.id.tvName);
        mTvAge = itemView.findViewById(R.id.tvAge);
        mTvRollNo = itemView.findViewById(R.id.tvRollNo);
    }

    public void setData(Student student) {
        mTvName.setText(student.getName());
        mTvAge.setText(student.getAge() + "");
        mTvRollNo.setText(student.getRollNo());
    }
}
