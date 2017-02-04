package com.example.jello.afterschool.parent.messageTeacher;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jello.afterschool.R;
import com.jsjrobotics.demeter.androidWrappers.DefaultView;

class MessageTeacherView implements DefaultView {

    private final View mRoot;

    MessageTeacherView(Activity activity, LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.chat_view, viewGroup, false);
    }

    @Override
    public View getLayout() {
        return mRoot;
    }

    @Override
    public void setLoading(boolean isLoading) {

    }

    @Override
    public void setError(boolean displayErrorScreen) {

    }
}
