package com.example.jello.afterschool.parent.homeScreen.android;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jello.afterschool.R;
import com.example.jello.afterschool.dataStructures.Teacher;

public class TeacherViewHolder extends RecyclerView.ViewHolder {
    private final TextView mName;
    private final TextView mSummary;
    private final ImageView mImage;

    public TeacherViewHolder(ViewGroup parent) {
        super(createView(parent));
        mName = (TextView) itemView.findViewById(R.id.name);
        mImage = (ImageView) itemView.findViewById(R.id.image);
        mSummary = (TextView) itemView.findViewById(R.id.summary);
    }

    private static View createView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.teacher_view_holder,parent, false);
    }

    public void setData(Teacher teacher) {
        mName.setText(teacher.getName());
        mSummary.setText(teacher.getId());
    }
}
