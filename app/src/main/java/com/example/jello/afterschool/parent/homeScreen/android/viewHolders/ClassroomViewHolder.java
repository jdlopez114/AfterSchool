package com.example.jello.afterschool.parent.homeScreen.android.viewHolders;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jello.afterschool.R;
import com.example.jello.afterschool.dataStructures.Classroom;

import java.lang.ref.WeakReference;

public class ClassroomViewHolder extends RecyclerView.ViewHolder {
    private final TextView mName;
    private final TextView mSchool;
    private final TextView mTeacher;
    private final TextView mClassId;
    private final View mRoot;

    public ClassroomViewHolder(ViewGroup parent) {
        super(createView(parent));
        mRoot = itemView;
        mName = (TextView) itemView.findViewById(R.id.nameView);
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

    public void setData(final WeakReference<Activity> activity, String className) {
        mName.setText(className);
        mTeacher.setText("Awesome Teacher");
        mSchool.setText("Exemplary school");
        mClassId.setText("Lost Class");
        mRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(view.getContext(), ViewStudents.class);
                Activity actualActivity = activity.get();
                if (actualActivity != null){
                    actualActivity.startActivity(intent);
                }

            }
        });
    }
}
