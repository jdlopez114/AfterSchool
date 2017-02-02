package com.example.jello.afterschool.parent.navigationDrawer;

import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.jsjrobotics.defaultTemplate.lifecycle.functional.Optional;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Receiver;

public class NavigationDrawer {
    private final RecyclerView mView;
    private final DrawerLayout mDrawerLayout;

    private Optional<Receiver<NavigationOption>> mListener = Optional.empty();
    private final Receiver<NavigationOption> mOnClicked = selected -> {
        mListener.ifPresent(listener -> listener.accept(selected));
    };

    public NavigationDrawer(Activity activity, RecyclerView view, DrawerLayout drawerLayout, Toolbar toolbar) {
        mView = view;
        mDrawerLayout = drawerLayout;
        mView.setAdapter(new NavigationDrawerAdapter(mOnClicked));
        mView.setLayoutManager(new LinearLayoutManager(mView.getContext()));
        mDrawerLayout.addDrawerListener(buildDrawerListener(activity, toolbar, drawerLayout));
    }

    private ActionBarDrawerToggle buildDrawerListener(Activity activity, Toolbar toolbar, DrawerLayout drawerLayout) {
        return new NavigationDrawerListener(activity, toolbar, drawerLayout);
    }

    public void setListener(Receiver<NavigationOption> listener) {
        mListener = Optional.ofNullable(listener);
    }
}
