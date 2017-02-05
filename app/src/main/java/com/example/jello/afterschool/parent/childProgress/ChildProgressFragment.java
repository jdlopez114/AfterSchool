package com.example.jello.afterschool.parent.childProgress;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.jsjrobotics.demeter.androidWrappers.DefaultFragment;

public class ChildProgressFragment extends DefaultFragment<ChildPresenter, ChildProgressView> {

    @Override
    protected ChildPresenter buildPresenter(Bundle savedInstanceState) {
        return new ChildPresenter(() -> this, savedInstanceState);
    }

    @Override
    protected ChildProgressView buildView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        return new ChildProgressView(getActivity(), inflater, viewGroup, savedInstanceState);
    }
}
