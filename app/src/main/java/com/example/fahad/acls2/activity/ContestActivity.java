package com.example.fahad.acls2.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.fahad.acls2.R;
import com.example.fahad.acls2.activity.adapter.ContestAdapter;
import com.example.fahad.acls2.activity.model.ContestBean;

import java.util.ArrayList;
import java.util.List;

public class ContestActivity extends AppCompatActivity {
    private int match_Id;
    private List<ContestBean> list;
    private ListView list_contest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contest);
        list_contest=findViewById(R.id.list_contest);
        /*if(getIntent()!=null){
            match_Id=getIntent().getIntExtra("Id",0);
        }*/
        list=new ArrayList<>();
        list.add(new ContestBean("4000 RS",20,"10,000 spots left","40 winners","4000","5000","S","C","A"));
        list.add(new ContestBean("4000 RS",40,"10,000 spots left","40 winners","0","5000","M","C","B"));
        list.add(new ContestBean("4000 RS",60,"10,000 spots left","40 winners","0","5000","M","N","B"));
        list.add(new ContestBean("4000 RS",80,"10,000 spots left","40 winners","0","5000","M","N","B"));
        list.add(new ContestBean("4000 RS",100,"10,000 spots left","40 winners","0","5000","M","N","B"));

        ContestAdapter adapter=new ContestAdapter(ContestActivity.this,R.layout.list_contest,list);
        list_contest.setAdapter(adapter);
    }
}
