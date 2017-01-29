package com.example.jello.afterschool.parent.childProgress;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.jello.afterschool.R;
import com.example.jello.afterschool.parent.homeScreen.android.HomeScreenFragment;
import com.jsjrobotics.defaultTemplate.lifecycle.AppCompatNavigationManager;
import com.jsjrobotics.defaultTemplate.lifecycle.appCompat.DefaultAppCompatLifecycleActivity;

public class ChildProgressActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.default_activity);
        if (savedInstanceState == null) {
            AppCompatNavigationManager.displayFragment(
                    this,
                    R.id.content,
                    new ChildProgressFragment(),
                    null
            );
        }
    }
}
