package com.example.sprint_4_evaluation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CovidResultAdapter extends RecyclerView.Adapter<CovidResultsViewHolder> {

    private List<ResponseModel> responseModelList;
    private OnItemClicked onItemClicked;

    public CovidResultAdapter(List<ResponseModel> responseModelList, OnItemClicked onItemClicked) {
        this.responseModelList = responseModelList;
        this.onItemClicked = onItemClicked;
    }

    @NonNull
    @Override
    public CovidResultsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent
                , false);
        return new CovidResultsViewHolder(view , onItemClicked);
    }

    @Override
    public void onBindViewHolder(@NonNull CovidResultsViewHolder holder, int position) {
        ResponseModel responseModel = responseModelList.get(position);
        holder.setData(responseModel);
    }

    @Override
    public int getItemCount() {
        return responseModelList.size();
    }

    public void updateAdapter(List<ResponseModel> responseModelList) {
        this.responseModelList = responseModelList;
        notifyDataSetChanged();
    }
}
