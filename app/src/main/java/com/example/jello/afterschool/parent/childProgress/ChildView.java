package com.example.jello.afterschool.parent.childProgress;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jello.afterschool.R;
import com.example.jello.afterschool.dataStructures.TestResult;
import com.jsjrobotics.demeter.androidWrappers.DefaultView;

class ChildView implements DefaultView {
    private final View mRoot;

    ChildView(FragmentActivity activity, LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.child_view, viewGroup, false);
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

    public void addTestResult(TestResult testResult) {

    }
}
