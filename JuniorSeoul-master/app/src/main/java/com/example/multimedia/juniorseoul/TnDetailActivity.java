package com.example.multimedia.juniorseoul;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.multimedia.juniorseoul.Classess.NTinfo;
import com.example.multimedia.juniorseoul.Classess.Ninfo;
import com.example.multimedia.juniorseoul.Classess.ServiceGenerator;
import com.example.multimedia.juniorseoul.Interface.NTinfoApiService;
import com.example.multimedia.juniorseoul.Interface.NinfoApiService;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TnDetailActivity extends AppCompatActivity {

    private TextView trsr_gubun, gubun, k_name, c_name, description, quantitiy, address, age;
    private ImageView detail_img;
    private MapView mapView;
    private String info, whichData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tn_detail);

        double latitude = getIntent().getDoubleExtra("latitude", 0.0);
        double longitude = getIntent().getDoubleExtra("longitude", 0.0);
        whichData = getIntent().getStringExtra("whichData");

        showMap(getIntent().getStringExtra("koreanNm"), latitude, longitude);

        trsr_gubun = (TextView)findViewById(R.id.tn_detail_trsr_gubun);
        gubun = (TextView)findViewById(R.id.tn_detail_gubun);
        k_name = (TextView)findViewById(R.id.tn_detail_kname);
        c_name = (TextView)findViewById(R.id.tn_detail_cname);
        description = (TextView)findViewById(R.id.tn_detail_description);
        quantitiy = (TextView)findViewById(R.id.tn_detail_quantity);
        address = (TextView)findViewById(R.id.tn_detail_address);
        age = (TextView)findViewById(R.id.tn_detail_age);
        detail_img = (ImageView)findViewById(R.id.tn_detail_img);

        detail_img.setImageResource(getIntent().getIntExtra("img", 0));
        address.setText(getIntent().getStringExtra("address"));
        trsr_gubun.setText(getIntent().getStringExtra("trsr_gubun") + " " + getIntent().getStringExtra("number"));
        k_name.setText(getIntent().getStringExtra("koreanNm"));
        c_name.setText(" ("+getIntent().getStringExtra("chineseNm" )+ ")");
        quantitiy.setText(getIntent().getStringExtra("quantity"));
        gubun.setText(getIntent().getStringExtra("gubun"));
        age.setText(getIntent().getStringExtra("age"));

        Log.d("statestate", getIntent().getStringExtra("stateN"));
        Log.d("idid", String.valueOf(getIntent().getIntExtra("id", 0)));


        if(whichData.equals("nationalT")){
            setNationalTreasureInfoAPI(getIntent().getStringExtra("stateN"), getIntent().getIntExtra("id", 0));
        }else if(whichData.equals("T")){
            setTreasureInfoAPI(getIntent().getStringExtra("stateN"), getIntent().getIntExtra("id", 0));
        }


    }

    public void showMap(String name, double latitude, double longitude){
        mapView = new MapView(this);
        mapView.setDaumMapApiKey("1e10c6bb9dc91481b02f90ccc00f2e21");
        RelativeLayout container = (RelativeLayout) findViewById(R.id.map_view);

        mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(latitude, longitude), true);
        mapView.setZoomLevel(3, true);

        MapPOIItem marker = new MapPOIItem();
        marker.setItemName(name);
        marker.setTag(0);
        marker.setMapPoint(MapPoint.mapPointWithGeoCoord(latitude, longitude));
        marker.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        mapView.addPOIItem(marker);

        container.addView(mapView);

    }

    public void setNationalTreasureInfoAPI(final String state, final int nt_id){
        NTinfoApiService api = ServiceGenerator.getNTinfoApiService();

        Call<NTinfo> call = api.getNTinfoApi(state, nt_id);

        call.enqueue(new Callback<NTinfo>() {
            @Override
            public void onResponse(Call<NTinfo> call, Response<NTinfo> response) {

                if (response.isSuccessful()) {
                    info = response.body().getInfo();

                    description.setText(info);
                }
            }

            @Override
            public void onFailure(Call<NTinfo> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "서버가 꺼져있습니다", Toast.LENGTH_LONG).show();
                t.printStackTrace();
                finish();
            }
        });
    }
    public void setTreasureInfoAPI(final String state, final int nt_id){
        NinfoApiService api = ServiceGenerator.getTinfoApiService();

        Call<Ninfo> call = api.getNinfoApi(state, nt_id);

        call.enqueue(new Callback<Ninfo>() {
            @Override
            public void onResponse(Call<Ninfo> call, Response<Ninfo> response) {

                if (response.isSuccessful()) {
                    info = response.body().getInfo();

                    description.setText(info);
                }
            }

            @Override
            public void onFailure(Call<Ninfo> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "서버가 꺼져있습니다", Toast.LENGTH_LONG).show();
                Log.getStackTraceString(t);
                t.printStackTrace();
                finish();
            }
        });
    }

}
