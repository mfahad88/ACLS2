package com.psl.fantasy.league.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.psl.fantasy.league.R;
import com.psl.fantasy.league.Utils.DbHelper;
import com.psl.fantasy.league.Utils.Helper;
import com.psl.fantasy.league.client.ApiClient;
import com.psl.fantasy.league.model.response.Config.ConfigBeanResponse;
import com.psl.fantasy.league.model.response.Player.PlayerResponse;

import org.json.JSONObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity {
    DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        dbHelper=new DbHelper(this);
        JSONObject obj=new JSONObject();
        try{
            obj.put("param_type","GF");
            obj.put("userId","1001");
            obj.put("method_Name",this.getClass().getSimpleName()+".onCreate");
            System.out.println(obj.toString());

            ApiClient.getInstance().getPlayersMatches().enqueue(new Callback<PlayerResponse>() {
                @Override
                public void onResponse(Call<PlayerResponse> call, Response<PlayerResponse> response) {
                    if(response.isSuccessful()){
                        if(response.body().getResponseCode().equals("1001")){

                            dbHelper.savePlayers(response.body().getData());
                        }else{
                            Helper.showAlertNetural(SplashActivity.this,"Error",response.body().getMessage());
                        }
                    }
                }

                @Override
                public void onFailure(Call<PlayerResponse> call, Throwable t) {
                    t.fillInStackTrace();
                    Helper.showAlertNetural(SplashActivity.this,"Error",t.getMessage());
                }
            });

            ApiClient.getInstance().getConfig(Helper.encrypt(obj.toString()))
                    .enqueue(new Callback<ConfigBeanResponse>() {
                        @Override
                        public void onResponse(Call<ConfigBeanResponse> call, Response<ConfigBeanResponse> response) {
                            if(response.isSuccessful()){
                                if(response.body().getResponseCode().equals("1001")){

                                    dbHelper.saveConfig(response.body().getData());

                                    new Handler().postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            Intent intent=new Intent(SplashActivity.this,StartActivity.class);

                                            startActivity(intent);
                                            finish();
                                        }
                                    },500);
                                }else{
                                    Helper.showAlertNetural(SplashActivity.this,"Error",response.body().getMessage());
                                }
                            }else{
                                try {
                                    Helper.showAlertNetural(SplashActivity.this,"Error",response.errorBody().string());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<ConfigBeanResponse> call, Throwable t) {
                            t.fillInStackTrace();
                            Helper.showAlertNetural(SplashActivity.this,"Error",t.getMessage());
                        }
                    });


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}