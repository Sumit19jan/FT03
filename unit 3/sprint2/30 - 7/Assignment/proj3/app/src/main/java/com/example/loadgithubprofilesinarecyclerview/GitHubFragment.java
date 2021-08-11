package com.example.loadgithubprofilesinarecyclerview;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GitHubFragment extends Fragment {

    private EditText mEtGithubId;
    private Button mBtnCallApi;
    private RecyclerView recyclerView;
    private GitHubAdapter gitHubAdapter;
    private List<ResponseModel> responseModelList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_git_hub, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }


    private void initViews(View view) {
        mEtGithubId = view.findViewById(R.id.etGithubId);
        mBtnCallApi = view.findViewById(R.id.btnCallApi);
        recyclerView = view.findViewById(R.id.rvRecyclerView);
        mBtnCallApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callApi();
            }
        });
    }

    private void callApi() {
        ApiClient apiClient = NetworkClass.getInstance().create(ApiClient.class);
        String user = mEtGithubId.getText().toString();
        apiClient.getUser(user).enqueue(new Callback<List<ResponseModel>>() {
            @Override
            public void onResponse(Call<List<ResponseModel>> call, Response<List<ResponseModel>> response) {
                if (response.code() == 200 && response.body() != null) {
                    buildData(response);
                    setAdapter();
                }
            }

            @Override
            public void onFailure(Call<List<ResponseModel>> call, Throwable t) {

            }
        });
    }

    private void setAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        gitHubAdapter = new GitHubAdapter(responseModelList);
        recyclerView.setAdapter(gitHubAdapter);
    }

    private void buildData(Response<List<ResponseModel>> response) {
        responseModelList = response.body();
    }

}