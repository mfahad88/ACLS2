package com.example.fahad.acls2.activity.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.fahad.acls2.R;
import com.example.fahad.acls2.activity.adapter.ContestAdapter;
import com.example.fahad.acls2.activity.model.ContestBean;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContestFragment extends Fragment {
    private View mView;
    private int match_Id;
    private List<ContestBean> list;
    private ListView list_contest;

    public ContestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView=inflater.inflate(R.layout.fragment_contest, container, false);

        list_contest=mView.findViewById(R.id.list_contest);
        /*if(getIntent()!=null){
            match_Id=getIntent().getIntExtra("Id",0);
        }*/
        list=new ArrayList<>();
        list.add(new ContestBean("4000 RS",20,"10,000 spots left","40 winners","4000","5000","S","C","A"));
        list.add(new ContestBean("4000 RS",40,"10,000 spots left","40 winners","0","5000","M","C","B"));
        list.add(new ContestBean("4000 RS",60,"10,000 spots left","40 winners","0","5000","M","N","B"));
        list.add(new ContestBean("4000 RS",80,"10,000 spots left","40 winners","0","5000","M","N","B"));
        list.add(new ContestBean("4000 RS",100,"10,000 spots left","40 winners","0","5000","M","N","B"));

        ContestAdapter adapter=new ContestAdapter(mView.getContext(),R.layout.list_contest,list);
        list_contest.setAdapter(adapter);
        return mView;
    }

}
