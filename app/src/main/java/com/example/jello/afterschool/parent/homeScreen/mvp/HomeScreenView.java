package com.example.jello.afterschool.parent.homeScreen.mvp;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.jello.afterschool.R;
import com.example.jello.afterschool.dataStructures.Child;
import com.example.jello.afterschool.dataStructures.Classroom;
import com.example.jello.afterschool.dataStructures.Parent;
import com.example.jello.afterschool.parent.homeScreen.android.adapters.ChildAdapter;
import com.example.jello.afterschool.parent.homeScreen.android.adapters.ClassroomAdapter;
import com.jsjrobotics.demeter.androidWrappers.DefaultView;
import com.example.jello.afterschool.dataStructures.Teacher;
import com.example.jello.afterschool.parent.homeScreen.android.adapters.TeacherAdapter;

public class HomeScreenView implements DefaultView {
    private static final int HOMESCREEN_SPAN = 2;
    private final View mRoot;
    private final View mLoading;
    private final View mLoaded;
    private final View mError;
    private final RecyclerView mTeachers;
    private final RecyclerView mChildren;
    private final RecyclerView mClassrooms;

    public HomeScreenView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.parent_homescreen_view, viewGroup, false);
        mLoading = mRoot.findViewById(R.id.loading);
        mLoaded = mRoot.findViewById(R.id.loaded);
        mError = mRoot.findViewById(R.id.error);
        mTeachers = (RecyclerView) mLoaded.findViewById(R.id.teachers);
        mChildren = (RecyclerView) mLoaded.findViewById(R.id.children);
        mClassrooms = (RecyclerView) mLoaded.findViewById(R.id.classrooms);
        setupTeachers();
        setupChildren();
        setupClassrooms();
        setLoading(true);
    }

    private void setupClassrooms() {
        mClassrooms.setAdapter(new ClassroomAdapter());
        mClassrooms.setLayoutManager(new GridLayoutManager(mRoot.getContext(), HOMESCREEN_SPAN));
    }

    private void setupChildren() {
        mChildren.setAdapter(new ChildAdapter());
        mChildren.setLayoutManager(new GridLayoutManager(mRoot.getContext(), HOMESCREEN_SPAN));
    }

    private void setupTeachers() {
        mTeachers.setAdapter(new TeacherAdapter());
        mTeachers.setLayoutManager(new GridLayoutManager(mRoot.getContext(), HOMESCREEN_SPAN));
    }

    public View getLayout() {
        return mRoot;
    }

    public void saveInstanceState(Bundle outState) {

    }

    @Override
    public void setLoading(boolean isLoading) {
        if (isLoading) {
            mError.setVisibility(View.GONE);
            mLoaded.setVisibility(View.GONE);
            mLoading.setVisibility(View.VISIBLE);
        } else {
            mError.setVisibility(View.GONE);
            mLoaded.setVisibility(View.VISIBLE);
            mLoading.setVisibility(View.GONE);
        }
    }

    @Override
    public void setError(boolean displayErrorScreen) {
        if (displayErrorScreen) {
            mError.setVisibility(View.VISIBLE);
            mLoaded.setVisibility(View.GONE);
            mLoading.setVisibility(View.GONE);
        } else {
            mError.setVisibility(View.GONE);
            mLoaded.setVisibility(View.GONE);
            mLoading.setVisibility(View.VISIBLE);
        }
    }

    public void addTeacher(Teacher item) {
        ((TeacherAdapter) mTeachers.getAdapter()).addData(item);
    }

    public void addChild(Child item) {
        ((ChildAdapter) mChildren.getAdapter()).addData(item);
    }

    public void addParent(Parent item) {

    }

    public void addClassroom(Classroom item) {
        ((ClassroomAdapter) mClassrooms.getAdapter()).addData(item);
    }
}
