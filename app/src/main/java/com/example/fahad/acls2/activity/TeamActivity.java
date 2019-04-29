package com.example.fahad.acls2.activity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.fahad.acls2.R;
import com.example.fahad.acls2.activity.adapter.PageAdapter;
import com.example.fahad.acls2.activity.interfaces.FragmentInterface;

public class TeamActivity extends AppCompatActivity {
    private ViewPager pager;
    private TabLayout tab_layout;
    PagerAdapter adapter;
    FragmentInterface fragmentInterface;
    int count_keeper=0;
    String wkt_keeper="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        pager=findViewById(R.id.pager);

        tab_layout=findViewById(R.id.tab_layout);
        fragmentInterface=new FragmentInterface() {
            @Override
            public void playerCount(int type, int count) {
                Toast.makeText(TeamActivity.this, type+","+count, Toast.LENGTH_SHORT).show();
                if(type==3){
                    tab_layout.getTabAt(0).setText("WK ("+count+")");
                }if(type==0){
                    tab_layout.getTabAt(1).setText("BAT ("+count+")");
                }if(type==2){
                    tab_layout.getTabAt(2).setText("AR ("+count+")");
                }if(type==1){
                    tab_layout.getTabAt(3).setText("BOWL ("+count+")");
                }
            }
        };
        tab_layout.addTab(tab_layout.newTab().setText("WK (0)"));
        tab_layout.addTab(tab_layout.newTab().setText("BAT (0)"));
        tab_layout.addTab(tab_layout.newTab().setText("AR (0)"));
        tab_layout.addTab(tab_layout.newTab().setText("BOWL (0)"));
        tab_layout.setTabGravity(TabLayout.GRAVITY_FILL);
        pager.setOffscreenPageLimit(tab_layout.getTabCount());
        adapter = new PageAdapter(getSupportFragmentManager(),tab_layout.getTabCount(),fragmentInterface);
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
