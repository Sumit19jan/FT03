package com.example.cachegthubresponse;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GithubViewHolder extends RecyclerView.ViewHolder {

    private TextView mTvName;
    private TextView mTvLogin;

    public GithubViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mTvName = itemView.findViewById(R.id.tvName);
        mTvLogin = itemView.findViewById(R.id.tvLogin);
    }

    public void setData(ResponseModel responseModel) {
        mTvName.setText(responseModel.getName());
        mTvLogin.setText(responseModel.getOwner().getLogin()+"");
    }
}
