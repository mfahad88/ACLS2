package com.example.fahad.acls2.activity.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.fahad.acls2.R;
import com.example.fahad.acls2.activity.adapter.FixtureAdapter;
import com.example.fahad.acls2.activity.model.MatchesBean;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {
    private ListView list_matches;
    private List<MatchesBean> list;
    private View mView;


    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView=inflater.inflate(R.layout.fragment_dashboard, container, false);
        init();
        list.add(new MatchesBean(1,"PK","AU","14:30:00"));
        list.add(new MatchesBean(2,"IN","BD","15:30:00"));
        list.add(new MatchesBean(3,"ZA","ZW","16:30:00"));
        list.add(new MatchesBean(4,"PK","IK","17:30:00"));
        FixtureAdapter fixtureAdapter=new FixtureAdapter(mView.getContext(),R.layout.list_fixture,list);
        list_matches.setAdapter(fixtureAdapter);
        list_matches.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment fragment=new ContestFragment();
                FragmentTransaction ft=getFragmentManager().beginTransaction();
                ft.replace(R.id.main_content,fragment);
                ft.commit();
            }
        });
        return mView;
    }

    private void init(){
        list_matches=mView.findViewById(R.id.list_matches);
        list=new ArrayList<>();
    }
}
