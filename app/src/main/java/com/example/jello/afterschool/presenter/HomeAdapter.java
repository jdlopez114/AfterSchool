package com.example.jello.afterschool.presenter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.example.jello.afterschool.model.Teacher;
import com.example.jello.afterschool.view.HomeViewHolder;
import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeViewHolder>{

    private List<Teacher> teacherList = new ArrayList<>();

    public HomeAdapter(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HomeViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {
        holder.setData(teacherList.get(position));
    }

    @Override
    public int getItemCount() {
        return teacherList.size();
    }
}
