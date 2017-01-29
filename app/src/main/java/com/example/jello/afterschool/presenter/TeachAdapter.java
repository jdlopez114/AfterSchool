package com.example.jello.afterschool.presenter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.example.jello.afterschool.model.Teacher;
import com.example.jello.afterschool.view.TeachViewHolder;
import java.util.ArrayList;
import java.util.List;

public class TeachAdapter extends RecyclerView.Adapter<TeachViewHolder>{

    private List<Teacher> teacherList = new ArrayList<>();

    public TeachAdapter(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    @Override
    public TeachViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TeachViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(TeachViewHolder holder, int position) {
        holder.setData(teacherList.get(position));
    }

    @Override
    public int getItemCount() {
        return teacherList.size();
    }
}
