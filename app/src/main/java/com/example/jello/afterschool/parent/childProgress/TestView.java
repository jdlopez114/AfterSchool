package com.example.jello.afterschool.parent.childProgress;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jello.afterschool.R;
import com.example.jello.afterschool.dataStructures.TestResult;

class TestView{
    private final View mView;
    private final TextView mGrade;
    private final TextView mTitle;
    TestView(ViewGroup parent, TestResult testResult) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        mView = inflater.inflate(R.layout.test_result,parent, false);
        mGrade = (TextView) mView.findViewById(R.id.testGrade);
        mTitle = (TextView) mView.findViewById(R.id.testTitle);
        mTitle.setText("Test: " + testResult.getTestId());
        mGrade.setText("Grade: " + testResult.getTestGrade());
    }

    public View getView() {
        return mView;
    }
}
