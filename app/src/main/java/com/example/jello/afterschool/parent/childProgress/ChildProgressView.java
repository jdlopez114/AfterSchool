package com.example.jello.afterschool.parent.childProgress;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.jello.afterschool.R;
import com.example.jello.afterschool.dataStructures.TestResult;
import com.jsjrobotics.defaultTemplate.lifecycle.appCompat.wrappers.DefaultAppCompatFragment;
import com.jsjrobotics.demeter.androidWrappers.DefaultView;

class ChildProgressView implements DefaultView {
    private final LinearLayout mRoot;

    ChildProgressView(FragmentActivity activity, LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        mRoot = (LinearLayout) inflater.inflate(R.layout.child_progress_view, viewGroup, false);
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

    void addTestResult(TestResult testResult) {
        ((Activity)mRoot.getContext()).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                View testView = new TestView(mRoot, testResult).getView();
                mRoot.addView(testView);
                mRoot.invalidate();
            }
        });

    }
}
