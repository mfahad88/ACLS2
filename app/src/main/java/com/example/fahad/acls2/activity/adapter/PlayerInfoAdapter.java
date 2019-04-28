package com.example.fahad.acls2.activity.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fahad.acls2.R;
import com.example.fahad.acls2.activity.model.PlayerBean;

import java.util.ArrayList;
import java.util.List;

public class PlayerInfoAdapter extends BaseAdapter {
    Context context;
    int resource;
    List<PlayerBean> list=new ArrayList<>();
    public PlayerInfoAdapter(Context context,int resource,List<PlayerBean> list) {
        this.context=context;
        this.resource=resource;
        this.list=list;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=LayoutInflater.from(context).inflate(resource,null);
        convertView.setBackgroundColor(Color.BLACK);
        PlayerBean bean=list.get(position);
        Toast.makeText(context, bean.getName(), Toast.LENGTH_SHORT).show();
        TextView txt_player_name=convertView.findViewById(R.id.txt_player_name);
        TextView txt_short_country=convertView.findViewById(R.id.txt_short_country);
        TextView txt_skill_player=convertView.findViewById(R.id.txt_skill_player);
        TextView txt_points=convertView.findViewById(R.id.txt_points);
        TextView txt_credits=convertView.findViewById(R.id.txt_credits);
        txt_player_name.setText(bean.getName());
        txt_points.setText(String.valueOf(bean.getPoints()));
        txt_credits.setText(String.valueOf(bean.getCredits()));
        txt_short_country.setText(bean.getShort_country());
        txt_skill_player.setText(bean.getSkill());
        final View finalConvertView = convertView;
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalConvertView.setBackgroundColor(Color.BLUE);
            }
        });
        return convertView;
    }
}
