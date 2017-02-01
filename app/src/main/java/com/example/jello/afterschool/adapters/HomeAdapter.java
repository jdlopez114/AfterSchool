package com.example.jello.afterschool.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.jello.afterschool.model.Children;
import com.example.jello.afterschool.viewholders.HomeViewHolder;
import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeViewHolder>{

    private List<Children> childrenList = new ArrayList<>();

    public HomeAdapter(List<Children> teacherList) {
        this.childrenList = teacherList;
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HomeViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {
        holder.setData(childrenList.get(position));
    }

    @Override
    public int getItemCount() {
        return childrenList.size();
    }
}
