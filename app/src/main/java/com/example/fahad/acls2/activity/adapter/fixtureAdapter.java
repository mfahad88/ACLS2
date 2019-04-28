package com.example.fahad.acls2.activity.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.fahad.acls2.R;
import com.example.fahad.acls2.activity.model.MatchesBean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class fixtureAdapter extends BaseAdapter {
    Context context;
    int resource;
    List<MatchesBean> list;
    public fixtureAdapter(Context context, int resource, List<MatchesBean> list) {
        this.context=context;
        this.resource=resource;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).getMatchId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");

        convertView=LayoutInflater.from(context).inflate(resource,null);
        final MatchesBean bean=list.get(position);
        Drawable drawable = null,drawable2 = null;
        ImageView image_team_one = convertView.findViewById(R.id.image_team_one);
        ImageView image_team_two = convertView.findViewById(R.id.image_team_two);
        final TextView txt_time = convertView.findViewById(R.id.txt_time);
        if(bean.getTeamOne().equalsIgnoreCase("pk")){
            drawable= context.getDrawable(R.drawable.drawable_pk);
        }if(bean.getTeamOne().equalsIgnoreCase("bd")){
            drawable= context.getDrawable(R.drawable.drawable_bd);
        }if(bean.getTeamOne().equalsIgnoreCase("in")){
            drawable= context.getDrawable(R.drawable.drawable_in);
        }if(bean.getTeamOne().equalsIgnoreCase("ik")){
            drawable= context.getDrawable(R.drawable.drawable_lk);
        }if(bean.getTeamOne().equalsIgnoreCase("au")){
            drawable= context.getDrawable(R.drawable.drawable_au);
        }
        /*if(bean.getTeamOne().equalsIgnoreCase("za")){
                drawable= context.getDrawable(R.drawable.drawable_sa);
            }if(bean.getTeamOne().equalsIgnoreCase("zw")){
                drawable= context.getDrawable(R.drawable.drawable_zmb);
            }*/

        if(bean.getTeamTwo().equalsIgnoreCase("pk")){
            drawable2= context.getDrawable(R.drawable.drawable_pk);
        }if(bean.getTeamTwo().equalsIgnoreCase("bd")){
            drawable2= context.getDrawable(R.drawable.drawable_bd);
        }if(bean.getTeamTwo().equalsIgnoreCase("in")){
            drawable2= context.getDrawable(R.drawable.drawable_in);
        }if(bean.getTeamTwo().equalsIgnoreCase("ik")){
            drawable2= context.getDrawable(R.drawable.drawable_lk);
        }if(bean.getTeamTwo().equalsIgnoreCase("au")){
            drawable2= context.getDrawable(R.drawable.drawable_au);
        }
        /*if(bean.getTeamTwo().equalsIgnoreCase("za")){
                drawable2= context.getDrawable(R.drawable.drawable_sa);
            }if(bean.getTeamTwo().equalsIgnoreCase("zw")){
                drawable2= context.getDrawable(R.drawable.drawable_zmb);
            }*/

        Glide.with(context).load(drawable).into(image_team_one);
        Glide.with(context).load(drawable2).into(image_team_two);
        txt_time.setText(bean.getTime());

        /*new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    txt_time.post(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                long durationInMillis=sdf.parse(bean.getTime()).getTime() - new Date().getTime();

                                long minute=TimeUnit.MILLISECONDS.toMinutes(durationInMillis);
                                long second=TimeUnit.MILLISECONDS.toSeconds(durationInMillis);
                                long hours=TimeUnit.MILLISECONDS.toHours(durationInMillis);




                                txt_time.setText(hours+":"+minute+":"+second);

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();*/
        return convertView;
    }
}
