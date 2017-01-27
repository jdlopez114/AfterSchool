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
import com.example.jello.afterschool.dataStructures.Child;
import com.example.jello.afterschool.dataStructures.Teacher;
import com.squareup.picasso.Picasso;

public class ChildViewHolder extends RecyclerView.ViewHolder {
    private final TextView mName;
    private final TextView mParent;
    private final ImageView mImage;
    private final TextView mChildId;
    private final TextView mClassrooms;

    public ChildViewHolder(ViewGroup parent) {
        super(createView(parent));
        mName = (TextView) itemView.findViewById(R.id.name);
        mImage = (ImageView) itemView.findViewById(R.id.image);
        mParent = (TextView) itemView.findViewById(R.id.parent);
        mChildId = (TextView) itemView.findViewById(R.id.childId);
        mClassrooms = (TextView) itemView.findViewById(R.id.classrooms);
    }

    private static View createView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.child_view_holder,parent, false);
    }

    public void setData(Child child) {
        Context context = itemView.getContext();
        mName.setText(child.getName());
        Picasso.with(context).load(AfterSchoolApi.getUrl(context, child.getImage())).into(mImage);
        mParent.setText(child.getParentId());
        mChildId.setText(child.getId());
        String classesEnrolled = "";
        for (String s : child.getClassrooms()) {
            if (!classesEnrolled.isEmpty()) {
                classesEnrolled += ",";
            }
            classesEnrolled += s;
        }
        mClassrooms.setText(classesEnrolled);
    }
}
