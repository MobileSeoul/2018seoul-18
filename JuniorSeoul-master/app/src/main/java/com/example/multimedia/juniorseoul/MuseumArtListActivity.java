package com.example.multimedia.juniorseoul;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.multimedia.juniorseoul.Adapter.MuseumArtListAdapter;
import com.example.multimedia.juniorseoul.Classess.ArtImgModel;
import com.example.multimedia.juniorseoul.Classess.KidsCafeListItem;
import com.example.multimedia.juniorseoul.Classess.MemorialImgModel;
import com.example.multimedia.juniorseoul.Classess.MuseumArtMemorial;
import com.example.multimedia.juniorseoul.Classess.MuseumArtMemorialList;
import com.example.multimedia.juniorseoul.Classess.MuseumImgModel;
import com.example.multimedia.juniorseoul.Classess.ServiceGenerator;
import com.example.multimedia.juniorseoul.DataHouse.StaticData;
import com.example.multimedia.juniorseoul.Interface.MuseumArtApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MuseumArtListActivity extends AppCompatActivity {

    private int which_data;
    private GridView listview;
    private MuseumArtListAdapter adapter;
    private static final String KIDS_CAFE_URL = "http://54.180.82.151:20000";
    private int count;
    private ProgressDialog progressDialog;
    private ArrayList<MuseumArtMemorialList> museumArtMemorialList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museum_art_list);

        Intent intent = getIntent();
        which_data = intent.getIntExtra("which_data", -1);

        listview = (GridView)findViewById(R.id.museum_art_listview);

        adapter = new MuseumArtListAdapter();

        switch (which_data){
            case 0:
                setArtMuseumMemorialListAPI("museum");
                break;

            case 1:
                setArtMuseumMemorialListAPI("art");
                break;

            case 2:
                setArtMuseumMemorialListAPI("memorial");
                break;
        }

    }
    private void setArtMuseumMemorialListAPI(final String operationName){

        MuseumArtApiService api = ServiceGenerator.getMuseumArtApiService();

        Call<MuseumArtMemorial> call = api.getMuseumArtMemorialList(operationName);

        call.enqueue(new Callback<MuseumArtMemorial>() {
            @Override
            public void onResponse(Call<MuseumArtMemorial> call, Response<MuseumArtMemorial> response) {

                if(response.isSuccessful()){
                    museumArtMemorialList = response.body().getMuseumArtMemorialList();

                    for(count=0; count<museumArtMemorialList.size(); count++){

                        if(operationName.equals("art")){
                            final List<ArtImgModel> art_list = StaticData.artImgList;

                            adapter.addItem(museumArtMemorialList.get(count).getName(), museumArtMemorialList.get(count).getState_name(), art_list.get(count).getImg());
                            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                                        Intent intent_to_detail = new Intent(getApplicationContext(), MuseumArtDetailActivity.class);

                                        intent_to_detail.putExtra("latitude", Double.parseDouble(museumArtMemorialList.get(position).getLatitude()));
                                        intent_to_detail.putExtra("longitude", Double.parseDouble(museumArtMemorialList.get(position).getLongitude()));
                                        intent_to_detail.putExtra("oper_page", museumArtMemorialList.get(position).getOper_page());
                                        intent_to_detail.putExtra("adult_pay", museumArtMemorialList.get(position).getAdult_pay());
                                        intent_to_detail.putExtra("child_pay", museumArtMemorialList.get(position).getChild_pay());
                                        intent_to_detail.putExtra("teenager_pay", museumArtMemorialList.get(position).getTeenager_pay());
                                        intent_to_detail.putExtra("address", museumArtMemorialList.get(position).getAddress());
                                        intent_to_detail.putExtra("oper_name", museumArtMemorialList.get(position).getOper_name());
                                        intent_to_detail.putExtra("oper_tel", museumArtMemorialList.get(position).getOper_tel());
                                        intent_to_detail.putExtra("name", museumArtMemorialList.get(position).getName());


                                        startActivity(intent_to_detail);
                                    }
                            });

                        }
                        else if(operationName.equals("memorial")){
                            final List<MemorialImgModel> memorial_list = StaticData.memorialImgList;

                            adapter.addItem(museumArtMemorialList.get(count).getName(), museumArtMemorialList.get(count).getState_name(), memorial_list.get(count).getImg());

                            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                                    Intent intent_to_detail = new Intent(getApplicationContext(), MuseumArtDetailActivity.class);

                                    intent_to_detail.putExtra("latitude", Double.parseDouble(museumArtMemorialList.get(position).getLatitude()));
                                    intent_to_detail.putExtra("longitude", Double.parseDouble(museumArtMemorialList.get(position).getLongitude()));
                                    intent_to_detail.putExtra("oper_page", museumArtMemorialList.get(position).getOper_page());
                                    intent_to_detail.putExtra("adult_pay", museumArtMemorialList.get(position).getAdult_pay());
                                    intent_to_detail.putExtra("child_pay", museumArtMemorialList.get(position).getChild_pay());
                                    intent_to_detail.putExtra("teenager_pay", museumArtMemorialList.get(position).getTeenager_pay());
                                    intent_to_detail.putExtra("address", museumArtMemorialList.get(position).getAddress());
                                    intent_to_detail.putExtra("oper_name", museumArtMemorialList.get(position).getOper_name());
                                    intent_to_detail.putExtra("oper_tel", museumArtMemorialList.get(position).getOper_tel());
                                    intent_to_detail.putExtra("name", museumArtMemorialList.get(position).getName());
                                    startActivity(intent_to_detail);
                                }
                            });
                        }
                        else if(operationName.equals("museum")){
                            final List<MuseumImgModel> museum_list = StaticData.museumImgList;
                            adapter.addItem(museumArtMemorialList.get(count).getName(), museumArtMemorialList.get(count).getState_name(), museum_list.get(count).getImg());
                            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                                    Intent intent_to_detail = new Intent(getApplicationContext(), MuseumArtDetailActivity.class);

                                    intent_to_detail.putExtra("latitude", Double.parseDouble(museumArtMemorialList.get(position).getLatitude()));
                                    intent_to_detail.putExtra("longitude", Double.parseDouble(museumArtMemorialList.get(position).getLongitude()));
                                    intent_to_detail.putExtra("oper_page", museumArtMemorialList.get(position).getOper_page());
                                    intent_to_detail.putExtra("adult_pay", museumArtMemorialList.get(position).getAdult_pay());
                                    intent_to_detail.putExtra("child_pay", museumArtMemorialList.get(position).getChild_pay());
                                    intent_to_detail.putExtra("teenager_pay", museumArtMemorialList.get(position).getTeenager_pay());
                                    intent_to_detail.putExtra("address", museumArtMemorialList.get(position).getAddress());
                                    intent_to_detail.putExtra("oper_name", museumArtMemorialList.get(position).getOper_name());
                                    intent_to_detail.putExtra("oper_tel", museumArtMemorialList.get(position).getOper_tel());
                                    intent_to_detail.putExtra("name", museumArtMemorialList.get(position).getName());

                                    startActivity(intent_to_detail);
                                }
                            });
                        }


                    }
                    listview.setAdapter(adapter);
                }

                else{
                    Toast.makeText(getApplicationContext(),"response fail", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MuseumArtMemorial> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"서버가 꺼져있습니다", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
