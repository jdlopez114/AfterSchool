package com.example.jello.afterschool.parent.homeScreen.android.viewHolders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jello.afterschool.R;
import com.example.jello.afterschool.backend.AfterSchoolApi;
import com.example.jello.afterschool.dataStructures.Teacher;
import com.squareup.picasso.Picasso;

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
        Context context = itemView.getContext();
        mName.setText(teacher.getName());
        Picasso.with(context).load(AfterSchoolApi.getUrl(context, teacher.getImage())).into(mImage);
        mSummary.setText(teacher.getId());
    }

}
