package com.example.jello.afterschool.view.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.jello.afterschool.R;
import com.example.jello.afterschool.model.AfterSchoolResponse;
import com.example.jello.afterschool.model.Children;
import com.example.jello.afterschool.model.Teacher;
import com.example.jello.afterschool.network.APIService;
import com.example.jello.afterschool.network.RetroHelper;
import com.example.jello.afterschool.presenter.HomeAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeViewHelper {

    private RecyclerView teacherRV;
    private View root;
    private static HomeAdapter homeAdapter;

    Children childrenList = new Children();

    public HomeViewHelper() {
    }

    public HomeViewHelper(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_recycler_view, viewGroup, false);
        teacherRV = (RecyclerView) viewGroup.findViewById(R.id.recycler_view);
        teacherRV.setLayoutManager(new LinearLayoutManager(viewGroup.getContext());
        teacherRV.setAdapter(homeAdapter);
    }
}
