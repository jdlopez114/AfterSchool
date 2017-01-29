package com.example.jello.afterschool.parent.childProgress;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.jsjrobotics.demeter.androidWrappers.DefaultFragment;

public class ChildProgressFragment extends DefaultFragment<ChildPresenter, ChildView> {

    @Override
    protected ChildPresenter buildPresenter(Bundle savedInstanceState) {
        return new ChildPresenter(() -> this, savedInstanceState);
    }

    @Override
    protected ChildView buildView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        return new ChildView(getActivity(), inflater, viewGroup, savedInstanceState);
    }
}
