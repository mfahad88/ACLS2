package com.example.fahad.acls2.activity.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fahad.acls2.R;
import com.example.fahad.acls2.activity.interfaces.PlayerInterface;
import com.example.fahad.acls2.activity.model.PlayerBean;

import java.util.ArrayList;
import java.util.List;

public class PlayerInfoAdapter extends ArrayAdapter<PlayerBean> {
    Context context;
    int resource;
    int player_Type;
    List<PlayerBean> list=new ArrayList<>();
    int count_wk=0;
    int count_bat=0;
    int count_alrounder=0;
    int count_bowl=0;
    int count_keeper=0;
    PlayerInterface playerInterface;
    public PlayerInfoAdapter(Context context, int resource, List<PlayerBean> list, int player_Type, PlayerInterface playerInterface) {
        super(context,resource,list);
        this.context=context;
        this.resource=resource;
        this.list=list;
        this.player_Type=player_Type;
        this.playerInterface=playerInterface;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=LayoutInflater.from(context).inflate(resource,null);
        TextView txt_player_name = convertView.findViewById(R.id.txt_player_name);
        TextView txt_short_country = convertView.findViewById(R.id.txt_short_country);
        TextView txt_skill_player = convertView.findViewById(R.id.txt_skill_player);
        TextView txt_points = convertView.findViewById(R.id.txt_points);
        TextView txt_credits = convertView.findViewById(R.id.txt_credits);
        ImageView image_view_plus=convertView.findViewById(R.id.image_view_plus) ;

        PlayerBean bean=list.get(position);
        txt_player_name.setText(bean.getName());
        txt_points.setText(String.valueOf(bean.getPoints()));
        txt_credits.setText(String.valueOf(bean.getCredits()));
        txt_short_country.setText(bean.getShort_country());
        txt_skill_player.setText(bean.getSkill());
        final View finalConvertView = convertView;

        if(player_Type==3) {
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  //  Toast.makeText(context, bean.getName(), Toast.LENGTH_SHORT).show();

                    if (list.get(position).isChecked()) {
                        if(count_wk==1) {
                            count_wk--;
                            playerInterface.playerCount(player_Type,count_wk);
                            finalConvertView.setSelected(false);
                            finalConvertView.setBackgroundColor(Color.parseColor("#FFFFFF"));
                            bean.setChecked(false);
                        }
                    } else {
                        if(count_wk==0) {
                            count_wk++;
                            playerInterface.playerCount(player_Type,count_wk);
                            finalConvertView.setSelected(true);
                            finalConvertView.setBackgroundColor(Color.parseColor("#FFF4DD"));
                            bean.setChecked(true);
                        }


                    }
                }

            });
        }
        if(player_Type==0) {
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //  Toast.makeText(context, bean.getName(), Toast.LENGTH_SHORT).show();

                    if (list.get(position).isChecked()) {
                        if(count_bat>1) {
                            count_bat--;
                            playerInterface.playerCount(player_Type,count_bat);
                            finalConvertView.setSelected(false);
                            finalConvertView.setBackgroundColor(Color.parseColor("#FFFFFF"));
                            bean.setChecked(false);
                        }
                    } else {
                        if(count_bat<5) {
                            count_bat++;
                            playerInterface.playerCount(player_Type,count_bat);
                            finalConvertView.setSelected(true);
                            finalConvertView.setBackgroundColor(Color.parseColor("#FFF4DD"));
                            bean.setChecked(true);
                        }


                    }
                }

            });
        }
        if(player_Type==2) {
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //  Toast.makeText(context, bean.getName(), Toast.LENGTH_SHORT).show();

                    if (list.get(position).isChecked()) {
                        if(count_alrounder>1) {
                            count_alrounder--;
                            playerInterface.playerCount(player_Type,count_alrounder);
                            finalConvertView.setSelected(false);
                            finalConvertView.setBackgroundColor(Color.parseColor("#FFFFFF"));
                            bean.setChecked(false);
                        }
                    } else {
                        if(count_alrounder<3) {
                            count_alrounder++;
                            playerInterface.playerCount(player_Type,count_alrounder);
                            finalConvertView.setSelected(true);
                            finalConvertView.setBackgroundColor(Color.parseColor("#FFF4DD"));
                            bean.setChecked(true);
                        }


                    }
                }

            });
        }
        if(player_Type==1) {
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //  Toast.makeText(context, bean.getName(), Toast.LENGTH_SHORT).show();

                    if (list.get(position).isChecked()) {
                        if(count_bowl>1) {
                            count_bowl--;
                            playerInterface.playerCount(player_Type,count_bowl);
                            finalConvertView.setSelected(false);
                            finalConvertView.setBackgroundColor(Color.parseColor("#FFFFFF"));
                            bean.setChecked(false);
                        }
                    } else {
                        if(count_bowl<5) {
                            count_bowl++;
                            playerInterface.playerCount(player_Type,count_bowl);
                            finalConvertView.setSelected(true);
                            finalConvertView.setBackgroundColor(Color.parseColor("#FFF4DD"));
                            bean.setChecked(true);
                        }


                    }
                }

            });
        }

        if(list.get(position).isChecked()){
            convertView.setSelected(true);
            convertView.setBackgroundColor(Color.parseColor("#FFF4DD"));
        }
        return convertView;

    }


}
