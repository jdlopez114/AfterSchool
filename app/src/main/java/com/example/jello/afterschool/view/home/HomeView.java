package com.example.jello.afterschool.view.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.jello.afterschool.R;
import com.example.jello.afterschool.adapters.HomeAdapter;
import com.example.jello.afterschool.model.Children;
import com.example.jello.afterschool.network.RetroHelper;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Retrofit;

public class HomeView  implements RetroHelper.RetrofitChildrenListener {

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
        Retrofit retrofit = RetroHelper.getInstance();
        RetroHelper.makeChildrenNetworkCall(retrofit, this); // passed in this because this notifies getChildren List when something changes
        teacherRV = (RecyclerView) root.findViewById(R.id.home_recycler_view);
        teacherRV.setLayoutManager(new LinearLayoutManager(root.getContext()));
        homeAdapter = new HomeAdapter(new ArrayList<>()); // initialize empty
        teacherRV.setAdapter(homeAdapter);
    }

    @Override
    public void getChildrenList(List<Children> childrenList) {
        homeAdapter = new HomeAdapter(childrenList); // assigned adapter with list, then pass in
        teacherRV.setAdapter(homeAdapter);
        homeAdapter.notifyDataSetChanged();
    }
}
