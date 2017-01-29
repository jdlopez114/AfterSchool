package com.example.jello.afterschool.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jello on 1/28/17.
 */

public class TeachViewHolder extends RecyclerView.ViewHolder {

    TextView name;
    ImageView image;
    TextView summary;

    public TeachViewHolder(ViewGroup parent) {
        super(createView(parent));
    }

    private static View createView(ViewGroup parent) {
        LayoutInflater inflater =
    }
}
