package com.example.jello.afterschool.presenter;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.jello.afterschool.R;
import com.example.jello.afterschool.view.calendar.CalendarFragment;
import com.example.jello.afterschool.view.chat.ChatFragment;
import com.example.jello.afterschool.view.home.HomeFragmentEnter;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    //    private BottomNavigationView bottomBar;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.container, new HomeFragmentEnter())
//                .commit();
//
//        bottomBar = (BottomNavigationView) findViewById(R.id.navigation);
//        bottomBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                selectFragment(item);
//                return true;
//            }
//        });
//    }
//
//    private void selectFragment(MenuItem item) {
//
//
//        switch (item.getItemId()) {
//            case R.id.menu_home:
//                getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.container, new HomeFragmentEnter())
//                        .commit();
//                break;
//            case R.id.menu_calendar:
//                getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.container, new CalendarFragment())
//                        .commit();
//                break;
//            case R.id.menu_chat:
//                getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.container, new ChatFragment())
//                        .commit();
//                break;
//        }
//    }
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomeFragmentEnter(), "HOME");
        adapter.addFragment(new CalendarFragment(), "CALENDAR");
        adapter.addFragment(new ChatFragment(), "CHAT");
        viewPager.setAdapter(adapter);
//        switch (item.getItemId()) {
//            case R.id.menu_home:
//                getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.container, new HomeFragmentEnter())
//                        .commit();
//                break;
//            case R.id.menu_calendar:
//                getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.container, new CalendarFragment())
//                        .commit();
//                break;
//            case R.id.menu_chat:
//                getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.container, new ChatFragment())
//                        .commit();
//                break;
//        }
    }
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> fragmentList = new ArrayList<>();
        private final List<String> tabTitleList = new ArrayList<>();
        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }
        @Override
        public int getCount() {
            return fragmentList.size();
        }
        //
        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitleList.get(position);
        }

        public void addFragment(Fragment fragment, String title) {
            fragmentList.add(fragment);
            tabTitleList.add(title);
        }
    }
}