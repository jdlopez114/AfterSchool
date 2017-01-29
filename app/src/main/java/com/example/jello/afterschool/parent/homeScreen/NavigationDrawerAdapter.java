package com.example.jello.afterschool.parent.homeScreen;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.jsjrobotics.defaultTemplate.lifecycle.functional.Receiver;

import java.util.Arrays;
import java.util.List;

class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerViewHolder> {
    private final List<NavigationOption> mOptions = Arrays.asList(
        NavigationOption.HOME,
        NavigationOption.CHILD_PROGRESS,
        NavigationOption.SEARCH_FOR_PROGRAMS,
        NavigationOption.MESSAGE_TEACHER
    );
    private final Receiver<NavigationOption> mListener;

    NavigationDrawerAdapter(Receiver<NavigationOption> clickListener) {
        mListener = clickListener;
    }

    @Override
    public NavigationDrawerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NavigationDrawerViewHolder(parent, mListener);
    }

    @Override
    public void onBindViewHolder(NavigationDrawerViewHolder holder, int position) {
        holder.setData(mOptions.get(position));
    }

    @Override
    public int getItemCount() {
        return mOptions.size();
    }
}
