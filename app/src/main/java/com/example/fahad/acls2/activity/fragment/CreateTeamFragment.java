package com.example.fahad.acls2.activity.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.fahad.acls2.R;
import com.example.fahad.acls2.activity.adapter.PlayerInfoAdapter;
import com.example.fahad.acls2.activity.model.PlayerBean;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateTeamFragment extends Fragment {

    ListView list_player;
    View mView;
    int Player_Type;
    public CreateTeamFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView=inflater.inflate(R.layout.fragment_create_team, container, false);
        list_player=mView.findViewById(R.id.list_player);
        if(getArguments()!=null){
            Player_Type=getArguments().getInt("Player_Type");
        }
        List<PlayerBean> list=new ArrayList<>();
        list.add(new PlayerBean("Kamran Akmal","PK","0",312.5f,20.0f));
        PlayerInfoAdapter adapter=new PlayerInfoAdapter(getActivity(),R.layout.player_info_adapter,list);
        list_player.setAdapter(adapter);
        list_player.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), position, Toast.LENGTH_SHORT).show();
            }
        });
        return mView;
    }

}
