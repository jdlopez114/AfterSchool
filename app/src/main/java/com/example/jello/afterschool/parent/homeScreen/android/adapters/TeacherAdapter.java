package com.example.jello.afterschool.parent.homeScreen.android.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.jello.afterschool.dataStructures.Teacher;
import com.example.jello.afterschool.parent.homeScreen.android.viewHolders.TeacherViewHolder;

import java.util.ArrayList;
import java.util.List;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherViewHolder> {
    private List<Teacher> mList = new ArrayList<>();

    @Override
    public TeacherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TeacherViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(TeacherViewHolder holder, int position) {
        holder.setData(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void addData(Teacher item) {
        mList.add(item);
        notifyDataSetChanged();
    }
}
