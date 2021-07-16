package com.example.inshortsnewsapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;


public class DataViewHolder extends RecyclerView.ViewHolder {

    private TextView mTvAuthor;
    private TextView mTvContent;
    private TextView mTvTitle;
    private TextView mtvDate;
    private TextView mTvTime;
    private ImageView mIvAvatar;

    public DataViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mTvAuthor = itemView.findViewById(R.id.tvAuthor);
        mTvTime = itemView.findViewById(R.id.tvTime);
        mTvTitle = itemView.findViewById(R.id.tvTitle);
        mTvContent = itemView.findViewById(R.id.tvContent);
        mtvDate = itemView.findViewById(R.id.tvDate);
        mIvAvatar = itemView.findViewById(R.id.ivAvatar);

    }

    public void setData(DataModel dataModel) {
        mTvAuthor.setText(dataModel.getAuthor());
        mTvContent.setText(dataModel.getContent());
        mTvTitle.setText(dataModel.getTitle());
        mTvTime.setText(dataModel.getTime());
        mtvDate.setText(dataModel.getDate());
        Glide.with(mIvAvatar).load(dataModel.getImageUrl()).into(mIvAvatar);
    }
}
