package com.example.jello.afterschool.parent.homeScreen.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jsjrobotics.defaultTemplate.lifecycle.appCompat.AppCompatNavigationManager;
import com.example.jello.afterschool.R;

public class HomeScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.default_activity);
        if (savedInstanceState == null) {
            AppCompatNavigationManager.displayFragment(
                    this,
                    R.id.content,
                    new HomeScreenFragment(),
                    null
            );
        }
    }
}
