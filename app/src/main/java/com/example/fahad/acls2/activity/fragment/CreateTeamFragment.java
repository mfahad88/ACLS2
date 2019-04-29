package com.example.fahad.acls2.activity.fragment;


import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fahad.acls2.R;
import com.example.fahad.acls2.activity.adapter.PlayerInfoAdapter;
import com.example.fahad.acls2.activity.model.PlayerBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateTeamFragment extends Fragment {

    ListView list_player;
    View mView;
    int Player_Type;
    public CreateTeamFragment() {

    }



    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView=inflater.inflate(R.layout.fragment_create_team, container, false);
        list_player=mView.findViewById(R.id.list_player);
        TextView txt_selection=mView.findViewById(R.id.txt_selection);
        if(getArguments()!=null){
            Player_Type=getArguments().getInt("Player_Type"); //0=batting ,1=bowling,2=alrounder,3=keeper
        }
        if(Player_Type==3) {
            txt_selection.setText("You can pick only 1 Wicket-keeper");
        }if(Player_Type==0) {
            txt_selection.setText("Pick 3-5 Batsmen");
        }if(Player_Type==2) {
            txt_selection.setText("Pick 1-3 All-Rounders");
        }if(Player_Type==1) {
            txt_selection.setText("Pick 3-5 Bowlers");
        }
        List<PlayerBean> player=new ArrayList<>();
        player.add(new PlayerBean("Kamran Akmal","PK","0",312.5,20.0,false));
        player.add(new PlayerBean("ABC","PK","0",312.5,20.0,false));
        player.add(new PlayerBean("ABC","AU","0",313.5,20.0,false));
        player.add(new PlayerBean("DEF","PK","0",314.5,20.0,false));
        player.add(new PlayerBean("DEF","AU","0",315.5,20.0,false));
        player.add(new PlayerBean("XYZ","PK","0",316.5,20.0,false));
        player.add(new PlayerBean("XYZ","AU","0",317.5,20.0,false));
        player.add(new PlayerBean("GHI","PK","0",318.5,20.0,false));
        player.add(new PlayerBean("GHI","AU","0",319.5,20.0,false));

        player.add(new PlayerBean("Kamran Akmal","PK","1",312.5,20.0,false));
        player.add(new PlayerBean("ABC","PK","1",312.5,20.0,false));
        player.add(new PlayerBean("ABC","AU","1",313.5,20.0,false));
        player.add(new PlayerBean("DEF","PK","1",314.5,20.0,false));
        player.add(new PlayerBean("DEF","AU","1",315.5,20.0,false));
        player.add(new PlayerBean("XYZ","PK","1",316.5,20.0,false));
        player.add(new PlayerBean("XYZ","AU","1",317.5,20.0,false));
        player.add(new PlayerBean("GHI","PK","1",318.5,20.0,false));
        player.add(new PlayerBean("GHI","AU","1",319.5,20.0,false));

        player.add(new PlayerBean("Kamran Akmal","PK","2",312.5,20.0,false));
        player.add(new PlayerBean("ABC","PK","2",312.5,20.0,false));
        player.add(new PlayerBean("ABC","AU","2",313.5,20.0,false));
        player.add(new PlayerBean("DEF","PK","2",314.5,20.0,false));
        player.add(new PlayerBean("DEF","AU","2",315.5,20.0,false));
        player.add(new PlayerBean("XYZ","PK","2",316.5,20.0,false));
        player.add(new PlayerBean("XYZ","AU","2",317.5,20.0,false));
        player.add(new PlayerBean("GHI","PK","2",318.5,20.0,false));
        player.add(new PlayerBean("GHI","AU","2",319.5,20.0,false));


        player.add(new PlayerBean("Kamran Akmal","PK","3",312.5,20.0,false));
        player.add(new PlayerBean("ABC","PK","3",312.5,20.0,false));
        player.add(new PlayerBean("ABC","AU","3",313.5,20.0,false));
        player.add(new PlayerBean("DEF","PK","3",314.5,20.0,false));
        player.add(new PlayerBean("DEF","AU","3",315.5,20.0,false));
        player.add(new PlayerBean("XYZ","PK","3",316.5,20.0,false));
        player.add(new PlayerBean("XYZ","AU","3",317.5,20.0,false));
        player.add(new PlayerBean("GHI","PK","3",318.5,20.0,false));
        player.add(new PlayerBean("GHI","AU","3",319.5,20.0,false));
        List<PlayerBean>list=player.stream().filter(p->p.getSkill().equals(String.valueOf(Player_Type))).collect(Collectors.toList());
        for(PlayerBean bean:list) {
            Log.e("List2-->", bean.toString());
        }

        PlayerInfoAdapter adapter=new PlayerInfoAdapter(mView.getContext(),R.layout.player_info_adapter,list);
        list_player.setAdapter(adapter);


        return mView;
    }

}
