package com.example.fahad.acls2.activity.fragment;


import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fahad.acls2.R;
import com.example.fahad.acls2.activity.adapter.PageAdapter;
import com.example.fahad.acls2.activity.interfaces.FragmentInterface;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeamFragment extends Fragment {
    private ViewPager pager;
    private TabLayout tab_layout;
    PagerAdapter adapter;
    FragmentInterface fragmentInterface;
    int count_keeper=0;
    String wkt_keeper="";
    private View mView;
    public TeamFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView=inflater.inflate(R.layout.fragment_team, container, false);

        pager=mView.findViewById(R.id.pager);

        tab_layout=mView.findViewById(R.id.tab_layout);
        fragmentInterface=new FragmentInterface() {
            @Override
            public void playerCount(int type, int count, int main) {
                //Toast.makeText(TeamActivity.this, type+","+count+","+main, Toast.LENGTH_SHORT).show();
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
        adapter = new PageAdapter(getFragmentManager(),tab_layout.getTabCount(),fragmentInterface);
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
        return mView;
    }

}
