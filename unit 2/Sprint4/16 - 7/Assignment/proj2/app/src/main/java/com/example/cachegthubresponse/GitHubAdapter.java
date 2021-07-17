package com.example.cachegthubresponse;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GitHubAdapter extends RecyclerView.Adapter<GithubViewHolder> {

    private List<ResponseModel> responseModels;

    public GitHubAdapter(List<ResponseModel> responseModels) {
        this.responseModels = responseModels;
    }

    @NonNull
    @Override
    public GithubViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new GithubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GithubViewHolder holder, int position) {
        ResponseModel responseModel = responseModels.get(position);
        holder.setData(responseModel);
    }

    @Override
    public int getItemCount() {
        return responseModels.size();
    }
}
