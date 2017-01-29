package com.example.jello.afterschool.parent.homeScreen.mvp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.jello.afterschool.R;
import com.example.jello.afterschool.dataStructures.Child;
import com.example.jello.afterschool.parent.homeScreen.NavigationDrawer;
import com.example.jello.afterschool.parent.homeScreen.NavigationOption;
import com.example.jello.afterschool.parent.homeScreen.android.adapters.ChildAdapter;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Receiver;
import com.jsjrobotics.demeter.androidWrappers.DefaultView;

public class HomeScreenView implements DefaultView {
    private static final int HOMESCREEN_SPAN = 2;
    private final View mRoot;
    private final View mLoading;
    private final View mLoaded;
    private final View mError;
    private final RecyclerView mChildren;
    private final NavigationDrawer mNavigationDrawer;

    public HomeScreenView(Activity activity, LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.parent_homescreen, viewGroup, false);
        mLoading = mRoot.findViewById(R.id.loading);
        mLoaded = mRoot.findViewById(R.id.loaded);
        mError = mRoot.findViewById(R.id.error);
        mChildren = (RecyclerView) mLoaded.findViewById(R.id.children);
        mNavigationDrawer = buildNavigationDrawer(activity);

        setupChildren(mRoot.getContext());
        setLoading(true);
    }

    private NavigationDrawer buildNavigationDrawer(Activity activity) {
        RecyclerView navigationDrawer = (RecyclerView) mRoot.findViewById(R.id.navigation_drawer);
        DrawerLayout drawerLayout = (DrawerLayout) mRoot.findViewById(R.id.drawer_layout);
        Toolbar toolbar = (Toolbar) mRoot.findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setTitleTextColor(0xFFFFFFFF);
        return new NavigationDrawer(activity, navigationDrawer, drawerLayout, toolbar);
    }

    private void setupChildren(Context context) {
        mChildren.setAdapter(new ChildAdapter());
        mChildren.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
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

    void addChild(Child item) {
        ((ChildAdapter) mChildren.getAdapter()).addData(item);
    }

    void setNavigationDrawerListener(Receiver<NavigationOption> listener) {
        mNavigationDrawer.setListener(listener);
    }

}
