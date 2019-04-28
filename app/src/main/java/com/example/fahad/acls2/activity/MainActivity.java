package com.example.fahad.acls2.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.fahad.acls2.R;
import com.example.fahad.acls2.activity.adapter.fixtureAdapter;
import com.example.fahad.acls2.activity.model.MatchesBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView list_matches;
    private List<MatchesBean> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        list.add(new MatchesBean(1,"PK","AU","14:30:00"));
        list.add(new MatchesBean(2,"IN","BD","15:30:00"));
        list.add(new MatchesBean(3,"ZA","ZW","16:30:00"));
        list.add(new MatchesBean(4,"PK","IK","17:30:00"));
        fixtureAdapter fixtureAdapter=new fixtureAdapter(this,R.layout.list_fixture,list);
        list_matches.setAdapter(fixtureAdapter);
        list_matches.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i =new Intent(getApplicationContext(),ContestActivity.class);
                i.putExtra("Id",id);
                startActivity(i);
            }
        });
    }

    private void init(){
        list_matches=findViewById(R.id.list_matches);
        list=new ArrayList<>();
    }
}
