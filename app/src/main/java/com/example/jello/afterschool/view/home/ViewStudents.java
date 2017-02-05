package com.example.jello.afterschool.view.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.example.jello.afterschool.R;
import com.example.jello.afterschool.view.home.HomeFragmentEnter;
import com.example.jello.afterschool.view.home.HomeView;

public class ViewStudents extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.default_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.content, new StudentDescription())
                    .commit();
        }
    }
}
