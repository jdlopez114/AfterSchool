package com.example.jello.afterschool.view.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.jello.afterschool.R;
import com.example.jello.afterschool.model.Children;
import com.example.jello.afterschool.network.RetroHelper;
import com.example.jello.afterschool.presenter.HomeAdapter;
import java.util.List;
import retrofit2.Retrofit;

public class HomeView {

    private RecyclerView teacherRV;
    private View root;
    private static HomeAdapter homeAdapter;

    public HomeView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.home_view, viewGroup, false);
    }

    public View getHomeView(){
        return root;
    }

    public void setUpChildren() {
        teacherRV = (RecyclerView) root.findViewById(R.id.home_recycler_view);
        teacherRV.setLayoutManager(new LinearLayoutManager(root.getContext()));
        Retrofit retrofit = RetroHelper.getInstance();
        List<Children> children = RetroHelper.getFullResponse(retrofit);
        homeAdapter = new HomeAdapter(children);
        teacherRV.setAdapter(homeAdapter);
    }
}
