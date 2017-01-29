package com.example.jello.afterschool.parent.searchPrograms;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.jello.afterschool.R;
import com.example.jello.afterschool.parent.childProgress.ChildProgressFragment;
import com.jsjrobotics.defaultTemplate.lifecycle.AppCompatNavigationManager;
import com.jsjrobotics.defaultTemplate.lifecycle.appCompat.wrappers.AppCompatActivityWrapper;
import com.jsjrobotics.defaultTemplate.lifecycle.appCompat.wrappers.interfaces.ILifecycleActivity;

public class SearchForProgramsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.default_activity);
        if (savedInstanceState == null) {
            AppCompatNavigationManager.displayFragment(
                    this,
                    R.id.content,
                    new SearchForProgramsFragment(),
                    null
            );
        }
    }
}
