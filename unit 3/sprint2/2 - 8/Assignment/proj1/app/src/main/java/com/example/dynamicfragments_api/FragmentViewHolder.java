package com.example.dynamicfragments_api;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class FragmentViewHolder extends RecyclerView.ViewHolder {

    private ImageView mIvImage;
    private TextView mTvOne;
    private TextView mTvTwo;
    public FragmentViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mIvImage = itemView.findViewById(R.id.ivImage);
        mTvOne = itemView.findViewById(R.id.tvOne);
        mTvTwo = itemView.findViewById(R.id.tvTwo);
    }

    public void setData(ResponseModel responseModel) {
        Glide.with(mIvImage).load(responseModel.getImage()).into(mIvImage);
        mTvOne.setText(responseModel.getTitle());
        mTvTwo.setText(responseModel.getSubTitle());
    }
}
