package com.example.chm.weatherapp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.luseen.luseenbottomnavigation.BottomNavigation.BottomNavigationItem;
import com.luseen.luseenbottomnavigation.BottomNavigation.BottomNavigationView;
import com.luseen.luseenbottomnavigation.BottomNavigation.OnBottomNavigationItemClickListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private ViewPager mPager;
    private ArrayList<Fragment> fragmentList;
    private FragAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
    }

    private void initview() {
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);
        mPager = (ViewPager) findViewById(R.id.viewPager);
        initviewbottomNavigationView();
        initviewViewPager();
        bottomNavigationView.selectTab(0);
    }

    private void initviewViewPager() {
        //构造适配器
        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new Fragment1());
        fragmentList.add(new Fragment2());
        fragmentList.add(new Fragment3());
        adapter = new FragAdapter(getSupportFragmentManager(), fragmentList);

        //设定适配器
        mPager.setAdapter(adapter);
        //设置不可左右滑动
        mPager .setOnTouchListener( new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                return true;
            }
        });
    }

    private void initviewbottomNavigationView() {

        int[] image = {R.drawable.tab_weather, R.drawable.tab_collection, R.drawable.tab_set};
        int[] color = {ContextCompat.getColor(this, R.color.firstColor),
                ContextCompat.getColor(this, R.color.secondColor),
                ContextCompat.getColor(this, R.color.fourthColor)};

        if (bottomNavigationView != null) {
            bottomNavigationView.isWithText(false);
            // bottomNavigationView.activateTabletMode();
            bottomNavigationView.isColoredBackground(true);
            bottomNavigationView.setTextActiveSize(getResources().getDimension(R.dimen.text_active));
            bottomNavigationView.setTextInactiveSize(getResources().getDimension(R.dimen.text_inactive));
            // bottomNavigationView.setItemActiveColorWithoutColoredBackground(ContextCompat.getColor(this, R.color.firstColor));
            // bottomNavigationView.setFont(Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/Noh_normal.ttf"));
        }

        BottomNavigationItem bottomNavigationItem = new BottomNavigationItem
                (getString(R.string.tab_Weather_name), color[0], image[0]);
        BottomNavigationItem bottomNavigationItem1 = new BottomNavigationItem
                (getString(R.string.tab1_collection_name), color[1], image[1]);
        BottomNavigationItem bottomNavigationItem2 = new BottomNavigationItem
                (getString(R.string.tab1_set_name), color[2], image[2]);
        bottomNavigationView.addTab(bottomNavigationItem);
        bottomNavigationView.addTab(bottomNavigationItem1);
        bottomNavigationView.addTab(bottomNavigationItem2);


        bottomNavigationView.setOnBottomNavigationItemClickListener(new OnBottomNavigationItemClickListener() {
            @Override
            public void onNavigationItemClick(int index) {
                switch (index) {
                    case 0:
                        mPager.setCurrentItem(index, true);
                        break;
                    case 1:
                        mPager.setCurrentItem(index, true);
                        break;
                    case 2:
                        mPager.setCurrentItem(index, true);
                        break;
                }
            }
        });
    }
}
