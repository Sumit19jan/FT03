package com.example.loadgithubprofilesinarecyclerview;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class GitHubViewHolder extends RecyclerView.ViewHolder{

    private TextView mTvName;
    private TextView mTvLogin;
    private ImageView mIvAvatar;

    public GitHubViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mTvLogin = itemView.findViewById(R.id.tvLogin);
        mTvName = itemView.findViewById(R.id.tvName);
        mIvAvatar = itemView.findViewById(R.id.ivAvatar);
    }

    public void setData(ResponseModel responseModel) {
        mTvName.setText(responseModel.getName());
        mTvLogin.setText(responseModel.getOwner().getLogin());
        Glide.with(mIvAvatar).load(responseModel.getOwner().getAvatarUrl()).into(mIvAvatar);
    }
}
