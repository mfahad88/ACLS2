package com.psl.fantasy.league.fragment;


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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.psl.fantasy.league.R;
import com.psl.fantasy.league.Utils.Helper;
import com.psl.fantasy.league.adapter.PageAdapter;
import com.psl.fantasy.league.interfaces.FragmentInterface;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeamFragment extends Fragment {
    private ViewPager pager;
    private TabLayout tab_layout;
    PagerAdapter adapter;
    FragmentInterface fragmentInterface;
    int count_keeper=0;
    int main=0;
    double credit=0;
    String wkt_keeper="";
    private View mView;
    private TextView txt_player_count;
    private TextView txt_credit_count;
    public char sign;
    private int contestId;
    private Button btn_done;
    public TeamFragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(mView.getContext(), "OnResume TeamFragment", Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView=inflater.inflate(R.layout.fragment_team, container, false);
        if(getArguments()!=null){
            contestId=getArguments().getInt("contestId");
        }
        btn_done=mView.findViewById(R.id.btn_done);
        pager=mView.findViewById(R.id.pager);
        txt_player_count=mView.findViewById(R.id.txt_player_count);
        txt_credit_count= mView.findViewById(R.id.txt_credit_count);
        tab_layout=mView.findViewById(R.id.tab_layout);
        fragmentInterface=new FragmentInterface() {
            @Override
            public void playerCount(int type, int count) {
//                Toast.makeText(TeamActivity.this, type+","+count+","+main, Toast.LENGTH_SHORT).show();
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

            @Override
            public void count(char ch) {
                sign=ch;
                if(ch=='+'){

                    main++;
                }else{
                    main--;
                }
                txt_player_count.setText(String.valueOf(main));
                if(main==14){
                    btn_done.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Helper.showAlertNetural(mView.getContext(),"Suceess","Team Saved...");
                        }
                    });
                }

            }

            @Override
            public void credit(double count) {
                if(sign=='+') {
                    credit = credit + count;
                }else {
                    credit = credit - count;
                }
//                Toast.makeText(mView.getContext(), String.valueOf(credit), Toast.LENGTH_SHORT).show();
                txt_credit_count.setText(String.valueOf(credit));
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