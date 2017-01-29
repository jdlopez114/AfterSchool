package com.example.jello.afterschool.parent.homeScreen;

import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.jello.afterschool.R;

public class NavigationDrawerListener extends ActionBarDrawerToggle {

    NavigationDrawerListener(Activity activity, Toolbar toolbar, DrawerLayout drawerLayout) {
        super(activity, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);

    }
}
