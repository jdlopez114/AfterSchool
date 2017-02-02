package com.example.jello.afterschool.parent.homeScreen.android;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.jello.afterschool.parent.homeScreen.mvp.HomeScreenView;
import com.jsjrobotics.demeter.androidWrappers.DefaultFragment;
import com.example.jello.afterschool.parent.homeScreen.mvp.HomeScreenPresenter;

public class HomeScreenFragment extends DefaultFragment<HomeScreenPresenter, HomeScreenView> {

    @Override
    protected HomeScreenPresenter buildPresenter(Bundle savedInstanceState) {
        return new HomeScreenPresenter(() -> this, savedInstanceState);
    }

    @Override
    protected HomeScreenView buildView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        return new HomeScreenView(inflater, viewGroup, savedInstanceState);
    }
}
