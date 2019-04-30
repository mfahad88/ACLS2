package com.psl.fantasy.league.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.psl.fantasy.league.R;
import com.psl.fantasy.league.Utils.Helper;
import com.psl.fantasy.league.adapter.FixtureAdapter;
import com.psl.fantasy.league.client.ApiClient;
import com.psl.fantasy.league.model.response.Matches.Datum;
import com.psl.fantasy.league.model.response.Matches.MatchesResponse;

import com.psl.fantasy.league.model.ui.MatchesBean;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        try{
            /*list.add(new MatchesBean(1,"PK","AU","14:30:00",1,2));
            list.add(new MatchesBean(2,"IN","BD","15:30:00",3,4));
            list.add(new MatchesBean(3,"ZA","ZW","16:30:00",5,6));*/

            JSONObject object=new JSONObject();
            object.put("method_Name",this.getClass().getSimpleName()+".onCreateView");
            ApiClient.getInstance().matches(Helper.encrypt(object.toString()))
                    .enqueue(new Callback<MatchesResponse>() {
                        @Override
                        public void onResponse(Call<MatchesResponse> call, Response<MatchesResponse> response) {
                            if(response.isSuccessful()){
                                if(response.body().getResponseCode().equals("1001")){
                                    for(Datum bean:response.body().getData()){

                                        list.add(new MatchesBean(bean.getMatchId().intValue(),bean.getTeamId1Name(),bean.getTeamId2Name(),bean.getStartDate(),bean.getTeamId1().intValue(),bean.getTeamId2().intValue()));
                                        FixtureAdapter fixtureAdapter=new FixtureAdapter(mView.getContext(),R.layout.list_fixture,list);
                                        list_matches.setAdapter(fixtureAdapter);
                                    }

                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<MatchesResponse> call, Throwable t) {

                        }
                    });
            for(MatchesBean bean:list){
                Log.e("MatchesBean",bean.toString());
            }

            /*list_matches.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Fragment fragment=new ContestFragment();
                    FragmentTransaction ft=getFragmentManager().beginTransaction();
                    ft.replace(R.id.main_content,fragment);
                    ft.commit();
                }
            });*/
        }catch (Exception e){
            e.printStackTrace();
        }
        return mView;
    }

    private void init(){
        list_matches=mView.findViewById(R.id.list_matches);
        list=new ArrayList<>();
    }
}
