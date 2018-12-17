package com.example.multimedia.juniorseoul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.multimedia.juniorseoul.Adapter.TreasureListAdapter;
import com.example.multimedia.juniorseoul.Classess.NTImgModel;
import com.example.multimedia.juniorseoul.Classess.NationalTreasure;
import com.example.multimedia.juniorseoul.Classess.NationalTreasureList;
import com.example.multimedia.juniorseoul.Classess.ServiceGenerator;
import com.example.multimedia.juniorseoul.Classess.TImgModel;
import com.example.multimedia.juniorseoul.Classess.Treasure;
import com.example.multimedia.juniorseoul.Classess.TreasureList;
import com.example.multimedia.juniorseoul.DataHouse.StaticData;
import com.example.multimedia.juniorseoul.Interface.NationalTreasureApiService;
import com.example.multimedia.juniorseoul.Interface.TreasureApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TnListActivity extends AppCompatActivity {
    private ArrayList<NationalTreasureList> nationalTreasureList;
    private ArrayList<TreasureList> treasureList;
    private int count;
    private ListView listView;
    private TreasureListAdapter adapter;
    private List<NTImgModel> imgList;
    private List<TImgModel> timgList;
    private String stateN;
    private String whichData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tn_list);

        whichData = getIntent().getStringExtra("whichData");
        String state = getIntent().getStringExtra("state");
        stateN = state;
        listView = (ListView)findViewById(R.id.tn_listview);
        adapter = new TreasureListAdapter();

        if(whichData.equals("nationalT")){

            setNationalTreasureListAPI(state);

        }else if(whichData.equals("T")){
            setTreasureListAPI(state);
        }
    }
    public void setNationalTreasureListAPI(final String state){
        NationalTreasureApiService api = ServiceGenerator.getNationalTreasureApiService();

        Call<NationalTreasure> call = api.getNationalTreasure(state);

        call.enqueue(new Callback<NationalTreasure>() {
            @Override
            public void onResponse(Call<NationalTreasure> call, Response<NationalTreasure> response) {

                if (response.isSuccessful()) {
                    nationalTreasureList = response.body().getNationalTreasureList();
                    listView.setAdapter(adapter);

                    switch (state){
                        case"B":
                            imgList = StaticData.ntJoongu;
                            nDataInit();

                            break;
                        case"D":
                            imgList = StaticData.ntYongsan;
                            nDataInit();

                            break;
                        case"H":
                            imgList = StaticData.ntSungbuk;
                            nDataInit();

                            break;
                        case"J":
                            imgList = StaticData.ntSeocho;
                            nDataInit();

                            break;
                        case"K":
                            imgList = StaticData.ntSeodaemun;
                            nDataInit();

                            break;
                        case"M":
                            imgList = StaticData.ntDongjak;
                            nDataInit();

                            break;
                        case"S":
                            imgList = StaticData.ntKwangjin;
                            nDataInit();

                            break;
                        case"T":
                            imgList = StaticData.ntKwanak;
                            nDataInit();

                            break;
                        case"X":
                            imgList = StaticData.ntKangnam;
                            nDataInit();

                            break;
                        case"Y":
                            imgList = StaticData.ntJongro;
                            nDataInit();

                            break;
                    }


                }
            }


            @Override
            public void onFailure(Call<NationalTreasure> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "서버가 꺼져있습니다", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
    public void nDataInit(){
        for (count = 0; count < nationalTreasureList.size(); count++) {

            if(nationalTreasureList.get(count).getAge()==null){
                if(nationalTreasureList.get(count).getChineseNm()==null){
                    adapter.addItem(imgList.get(count).getImg(),nationalTreasureList.get(count).getKoreanNm(), "", "시대미상", nationalTreasureList.get(count).getNumber());
                }else{
                    adapter.addItem(imgList.get(count).getImg(),nationalTreasureList.get(count).getKoreanNm(), nationalTreasureList.get(count).getChineseNm(), "시대미상", nationalTreasureList.get(count).getNumber());
                }

            }else{
                if(nationalTreasureList.get(count).getChineseNm()==null){
                    adapter.addItem(imgList.get(count).getImg(),nationalTreasureList.get(count).getKoreanNm(), "", nationalTreasureList.get(count).getAge(), nationalTreasureList.get(count).getNumber());
                }else{
                    adapter.addItem(imgList.get(count).getImg(),nationalTreasureList.get(count).getKoreanNm(), nationalTreasureList.get(count).getChineseNm(), nationalTreasureList.get(count).getAge(), nationalTreasureList.get(count).getNumber());
                }
            }
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), TnDetailActivity.class);

                intent.putExtra("img", imgList.get(i).getImg());
                intent.putExtra("address", nationalTreasureList.get(i).getAddress());
                intent.putExtra("stateN", stateN);

                if(nationalTreasureList.get(i).getAge()==null){
                    intent.putExtra("age", "시대미상");
                }else{
                    intent.putExtra("age", nationalTreasureList.get(i).getAge());
                }

                if(nationalTreasureList.get(i).getChineseNm()==null){
                    intent.putExtra("chineseNm", "");
                }else{
                    intent.putExtra("chineseNm", nationalTreasureList.get(i).getChineseNm());
                }
                intent.putExtra("koreanNm", nationalTreasureList.get(i).getKoreanNm());
                intent.putExtra("gubun", nationalTreasureList.get(i).getGubun());
                intent.putExtra("id", nationalTreasureList.get(i).getId());
                intent.putExtra("latitude", nationalTreasureList.get(i).getLatitude());
                intent.putExtra("longitude", nationalTreasureList.get(i).getLongitude());
                intent.putExtra("latitude", Double.parseDouble(nationalTreasureList.get(i).getLatitude()));
                intent.putExtra("longitude", Double.parseDouble(nationalTreasureList.get(i).getLongitude()));
                intent.putExtra("number", nationalTreasureList.get(i).getNumber());
                intent.putExtra("quantity", nationalTreasureList.get(i).getQuantity());
                intent.putExtra("state", nationalTreasureList.get(i).getState());
                intent.putExtra("trsr_gubun", nationalTreasureList.get(i).getTrsr_gubun());
                intent.putExtra("whichData", whichData);

                startActivity(intent);
            }
        });
    }

    public void setTreasureListAPI(final String state){
        TreasureApiService api = ServiceGenerator.getTreasureApiService();

        Call<Treasure> call = api.getTreasure(state);

        call.enqueue(new Callback<Treasure>() {
            @Override
            public void onResponse(Call<Treasure> call, Response<Treasure> response) {

                if (response.isSuccessful()) {
                    treasureList = response.body().getTreasureList();
                    listView.setAdapter(adapter);

                    switch (state){
                        case"B":
                            timgList = StaticData.tJunggu;
                            tDataInit();

                            break;
                        case"C":
                            timgList = StaticData.tEunpyeong;
                            tDataInit();

                            break;
                        case"D":
                            timgList = StaticData.tYongsan;
                            tDataInit();

                            break;
                        case"G":
                            timgList = StaticData.tSongpa;
                            tDataInit();

                            break;
                        case"H":
                            timgList = StaticData.tSungbuk;
                            tDataInit();

                            break;
                        case"J":
                            timgList = StaticData.tSeocho;
                            tDataInit();

                            break;
                        case"K":
                            timgList = StaticData.tSeodaemun;
                            tDataInit();

                            break;
                        case"L":
                            timgList = StaticData.tMapo;
                            tDataInit();

                            break;
                        case"M":
                            timgList = StaticData.tDongjak;
                            tDataInit();

                            break;
                        case"N":
                            timgList = StaticData.tDongdaemun;
                            tDataInit();

                            break;
                        case"P":
                            timgList = StaticData.tNowon;
                            tDataInit();

                            break;
                        case"S":
                            timgList = StaticData.tGwangjin;
                            tDataInit();

                            break;
                        case"T":
                            timgList = StaticData.tGwanak;
                            tDataInit();

                            break;
                        case"U":
                            timgList = StaticData.tGangseo;
                            tDataInit();

                            break;
                        case"V":
                            timgList = StaticData.tGangbuk;
                            tDataInit();

                            break;
                        case"X":
                            timgList = StaticData.tGangnam;
                            tDataInit();

                            break;

                        case"Y":
                            timgList = StaticData.tJongno;
                            tDataInit();

                            break;

                    }


                }
            }


            @Override
            public void onFailure(Call<Treasure> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "서버가 꺼져있습니다", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
    public void tDataInit(){
        for (count = 0; count < treasureList.size(); count++) {

            if(treasureList.get(count).getAge()==null){
                if(treasureList.get(count).getChineseNm()==null){
                    adapter.addItem(timgList.get(count).getImg(),treasureList.get(count).getKoreanNm(), "", "시대미상", treasureList.get(count).getNumber());
                }else{
                    adapter.addItem(timgList.get(count).getImg(),treasureList.get(count).getKoreanNm(), treasureList.get(count).getChineseNm(), "시대미상", treasureList.get(count).getNumber());
                }

            }else{
                if(treasureList.get(count).getChineseNm()==null){
                    adapter.addItem(timgList.get(count).getImg(),treasureList.get(count).getKoreanNm(), "", treasureList.get(count).getAge(), treasureList.get(count).getNumber());
                }else{
                    adapter.addItem(timgList.get(count).getImg(),treasureList.get(count).getKoreanNm(), treasureList.get(count).getChineseNm(), treasureList.get(count).getAge(), treasureList.get(count).getNumber());
                }
            }
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), TnDetailActivity.class);

                intent.putExtra("img", timgList.get(i).getImg());
                intent.putExtra("address", treasureList.get(i).getAddress());
                intent.putExtra("stateN", stateN);

                if(treasureList.get(i).getAge()==null){
                    intent.putExtra("age", "시대미상");
                }else{
                    intent.putExtra("age", treasureList.get(i).getAge());
                }

                if(treasureList.get(i).getChineseNm()==null){
                    intent.putExtra("chineseNm", "");
                }else{
                    intent.putExtra("chineseNm", treasureList.get(i).getChineseNm());
                }
                intent.putExtra("koreanNm", treasureList.get(i).getKoreanNm());
                intent.putExtra("gubun", treasureList.get(i).getGubun());
                intent.putExtra("id", treasureList.get(i).getId());
                intent.putExtra("latitude", treasureList.get(i).getLatitude());
                intent.putExtra("longitude", treasureList.get(i).getLongitude());
                intent.putExtra("latitude", Double.parseDouble(treasureList.get(i).getLatitude()));
                intent.putExtra("longitude", Double.parseDouble(treasureList.get(i).getLongitude()));
                intent.putExtra("number", treasureList.get(i).getNumber());
                intent.putExtra("quantity", treasureList.get(i).getQuantity());
                intent.putExtra("state", treasureList.get(i).getState());
                intent.putExtra("trsr_gubun", treasureList.get(i).getTrsr_gubun());
                intent.putExtra("whichData", whichData);

                startActivity(intent);
            }
        });
    }
}
