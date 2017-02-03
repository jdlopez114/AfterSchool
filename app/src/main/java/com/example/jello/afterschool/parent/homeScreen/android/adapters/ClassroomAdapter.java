package com.example.jello.afterschool.parent.homeScreen.android.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.jello.afterschool.dataStructures.Classroom;
import com.example.jello.afterschool.parent.homeScreen.android.viewHolders.ClassroomViewHolder;

import java.util.ArrayList;
import java.util.List;

public class ClassroomAdapter extends RecyclerView.Adapter<ClassroomViewHolder> {
    private List<Classroom> mList = new ArrayList<>();

    @Override
    public ClassroomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ClassroomViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(ClassroomViewHolder holder, int position) {
        holder.setData(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void addData(Classroom item) {
        mList.add(item);
        notifyDataSetChanged();
    }
}
