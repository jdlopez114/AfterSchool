package com.example.jello.afterschool.parent.childProgress;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jello.afterschool.R;
import com.example.jello.afterschool.backend.AfterSchoolApi;
import com.example.jello.afterschool.dataStructures.Child;
import com.example.jello.afterschool.dataStructures.TestResult;
import com.jsjrobotics.defaultTemplate.lifecycle.appCompat.wrappers.DefaultAppCompatFragment;
import com.jsjrobotics.demeter.androidWrappers.DefaultView;
import com.squareup.picasso.Picasso;

class ChildProgressView implements DefaultView {
    private final LinearLayout mRoot;
    private final TextView mName;
    private final ImageView mImage;

    ChildProgressView(FragmentActivity activity, LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        mRoot = (LinearLayout) inflater.inflate(R.layout.child_progress_view, viewGroup, false);
        mName = (TextView) mRoot.findViewById(R.id.name);
        mImage = (ImageView) mRoot.findViewById(R.id.image);
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
                mName.setText("BILLY the Kid");
                Picasso.with(mRoot.getContext()).load("http://jsjrobotics.nyc/classroom/photos/letter_C.jpg").into(mImage);

                mRoot.invalidate();
            }
        });

    }

    public void addChild(final Child item) {
        ((Activity)mRoot.getContext()).runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
