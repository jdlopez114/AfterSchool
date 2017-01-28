package com.example.jello.afterschool;

import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.jello.afterschool.fragments.HomeFragment;
import com.example.jello.afterschool.fragments.SearchFragment;
import com.example.jello.afterschool.fragments.StudentsFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomBar = (BottomNavigationView) findViewById(R.id.navigation);
        bottomBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectFragment(item);
                return true;
            }
        });
    }

    private void selectFragment(MenuItem item) {

        FragmentManager fm = getSupportFragmentManager();

        switch (item.getItemId()) {
            case R.id.menu_home:
                fm
                        .beginTransaction()
                        .add(R.id.container, new SearchFragment())
                        .commit();
                break;
            case R.id.menu_search:
                fm
                        .beginTransaction()
                        .add(R.id.container, new HomeFragment())
                        .commit();
                break;
            case R.id.menu_students:
                fm
                        .beginTransaction()
                        .add(R.id.container, new StudentsFragment())
                        .commit();
                break;
        }
    }
}