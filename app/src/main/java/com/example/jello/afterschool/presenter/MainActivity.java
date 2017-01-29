package com.example.jello.afterschool.presenter;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.jello.afterschool.R;
import com.example.jello.afterschool.view.home.HomeFragment;
import com.example.jello.afterschool.view.curriculum.CurriculumFragment;
import com.example.jello.afterschool.view.chat.ChatFragment;

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
                        .replace(R.id.container, new HomeFragment())
                        .commit();
                break;
            case R.id.menu_calendar:
                fm
                        .beginTransaction()
                        .replace(R.id.container, new CurriculumFragment())
                        .commit();
                break;
            case R.id.menu_chat:
                fm
                        .beginTransaction()
                        .replace(R.id.container, new ChatFragment())
                        .commit();
                break;
        }
    }
}