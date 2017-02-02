package com.example.jello.afterschool.parent.navigationDrawer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jello.afterschool.R;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Receiver;

public class NavigationDrawerViewHolder extends RecyclerView.ViewHolder {
    private final TextView mLabel;
    private final View mRoot;
    private final Receiver<NavigationOption> mClickListener;

    public NavigationDrawerViewHolder(ViewGroup parent, Receiver<NavigationOption> clickListener) {
        super(createView(parent));
        mRoot = itemView;
        mLabel = (TextView) mRoot.findViewById(R.id.label);
        mClickListener = clickListener;
    }

    private static View createView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.navigation_drawer_item, parent, false);
    }

    public void setData(final NavigationOption data) {
        mLabel.setText(data.getDisplayName());
        mLabel.setOnClickListener(view -> {
            mClickListener.accept(data);
        });
    }
}
