package com.example.jello.afterschool.parent.homeScreen.android.viewHolders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jello.afterschool.R;
import com.example.jello.afterschool.dataStructures.Classroom;
import com.example.jello.afterschool.dataStructures.Teacher;

public class ClassroomViewHolder extends RecyclerView.ViewHolder {
    private final TextView mName;
    private final TextView mSchool;
    private final TextView mTeacher;
    private final TextView mClassId;

    public ClassroomViewHolder(ViewGroup parent) {
        super(createView(parent));
        mName = (TextView) itemView.findViewById(R.id.name);
        mTeacher = (TextView) itemView.findViewById(R.id.teacher);
        mSchool = (TextView) itemView.findViewById(R.id.school);
        mClassId = (TextView) itemView.findViewById(R.id.classId);
    }

    private static View createView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.classroom_view_holder,parent, false);
    }

    public void setData(Classroom classroom) {
        mName.setText(classroom.getName());
        mTeacher.setText(classroom.getTeacher());
        mSchool.setText(classroom.getSchool());
        mClassId.setText(classroom.getId());
    }
}
