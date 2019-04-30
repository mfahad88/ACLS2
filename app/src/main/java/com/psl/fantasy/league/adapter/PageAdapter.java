package com.psl.fantasy.league.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.psl.fantasy.league.fragment.CreateTeamFragment;
import com.psl.fantasy.league.interfaces.FragmentInterface;

public class PageAdapter extends FragmentPagerAdapter {

    private int numOfTabs;
    Fragment fragment;
    FragmentInterface fragmentInterface;
    public PageAdapter(FragmentManager fm, int numOfTabs, FragmentInterface fragmentInterface) {
        super(fm);
        this.numOfTabs = numOfTabs;
        this.fragmentInterface=fragmentInterface;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                fragment=new CreateTeamFragment(fragmentInterface);
                Bundle bundle_wk=new Bundle();
                bundle_wk.putInt("Player_Type",3);
                fragment.setArguments(bundle_wk);
                Log.e("Player_Type", String.valueOf(3));
                return fragment;
            case 1:
                fragment=new CreateTeamFragment(fragmentInterface);
                Bundle bundle_bat=new Bundle();
                bundle_bat.putInt("Player_Type",0);
                fragment.setArguments(bundle_bat);
                Log.e("Player_Type", String.valueOf(0));
                return fragment;
            case 2:
                fragment=new CreateTeamFragment(fragmentInterface);
                Bundle bundle_ar=new Bundle();
                bundle_ar.putInt("Player_Type",2);
                fragment.setArguments(bundle_ar);
                Log.e("Player_Type", String.valueOf(2));
                return fragment;
            case 3:
                fragment=new CreateTeamFragment(fragmentInterface);
                Bundle bundle_bowl=new Bundle();
                bundle_bowl.putInt("Player_Type",1);
                fragment.setArguments(bundle_bowl);
                Log.e("Player_Type", String.valueOf(1));
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