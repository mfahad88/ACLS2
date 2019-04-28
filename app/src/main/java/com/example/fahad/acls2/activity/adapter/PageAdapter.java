package com.example.fahad.acls2.activity.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.fahad.acls2.activity.fragment.CreateTeamFragment;

public class PageAdapter extends FragmentPagerAdapter {

    private int numOfTabs;
    Fragment fragment;
    public PageAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                fragment=new CreateTeamFragment();
                Bundle bundle_wk=new Bundle();
                bundle_wk.putInt("Player_Type",3);
                fragment.setArguments(bundle_wk);
                return fragment;
            case 1:
                fragment=new CreateTeamFragment();
                Bundle bundle_bat=new Bundle();
                bundle_bat.putInt("Player_Type",0);
                fragment.setArguments(bundle_bat);
                return fragment;
            case 2:
                fragment=new CreateTeamFragment();
                Bundle bundle_ar=new Bundle();
                bundle_ar.putInt("Player_Type",2);
                fragment.setArguments(bundle_ar);
                return fragment;
            case 3:
                fragment=new CreateTeamFragment();
                Bundle bundle_bowl=new Bundle();
                bundle_bowl.putInt("Player_Type",1);
                fragment.setArguments(bundle_bowl);
                return fragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}