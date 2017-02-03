package com.example.jello.afterschool.parent.homeScreen.android.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.jello.afterschool.dataStructures.Child;
import com.example.jello.afterschool.parent.homeScreen.android.viewHolders.ChildViewHolder;

import java.util.ArrayList;
import java.util.List;

public class ChildAdapter extends RecyclerView.Adapter<ChildViewHolder> {
    private List<Child> mList = new ArrayList<>();

    @Override
    public ChildViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ChildViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(ChildViewHolder holder, int position) {
        holder.setData(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void addData(Child item) {
        mList.add(item);
        notifyDataSetChanged();
    }
}
