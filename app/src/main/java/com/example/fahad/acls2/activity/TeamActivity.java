package com.example.fahad.acls2.activity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.fahad.acls2.R;
import com.example.fahad.acls2.activity.adapter.PageAdapter;

public class TeamActivity extends AppCompatActivity {
    private ViewPager pager;
    private TabLayout tab_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        pager=findViewById(R.id.pager);
        tab_layout=findViewById(R.id.tab_layout);
        tab_layout.addTab(tab_layout.newTab().setText("WK"));
        tab_layout.addTab(tab_layout.newTab().setText("BAT"));
        tab_layout.addTab(tab_layout.newTab().setText("AR"));
        tab_layout.addTab(tab_layout.newTab().setText("BOWL"));
        tab_layout.setTabGravity(TabLayout.GRAVITY_FILL);
        PagerAdapter adapter=new PageAdapter(getSupportFragmentManager(),tab_layout.getTabCount());
        pager.setAdapter(adapter);
        tab_layout.setTabTextColors(ColorStateList.valueOf(Color.BLACK));
        tab_layout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
