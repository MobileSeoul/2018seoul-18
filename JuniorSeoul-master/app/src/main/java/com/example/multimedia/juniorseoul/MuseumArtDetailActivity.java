package com.example.multimedia.juniorseoul;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

public class MuseumArtDetailActivity extends AppCompatActivity {

    private String name, address, oper_tel, oper_name, oper_page, adult_pay, teenager_pay, child_pay;
    private double latitude, longitude;
    private TextView nameTv, addressTv, telTv,  adminTv,  websiteTv,  adultTv,  tenagerTv,  kidTv;
    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museum_art_detail);

        nameTv = (TextView)findViewById(R.id.name);
        addressTv = (TextView)findViewById(R.id.address);
        telTv = (TextView)findViewById(R.id.tel);
        adultTv = (TextView)findViewById(R.id.adult_price);
        tenagerTv = (TextView)findViewById(R.id.teenager_price);
        kidTv = (TextView)findViewById(R.id.kid_price);
        websiteTv = (TextView)findViewById(R.id.website);
        adminTv = (TextView)findViewById(R.id.administraion);

        Intent intent = getIntent();

        address = intent.getStringExtra("address");
        oper_tel = intent.getStringExtra("oper_tel");
        name = intent.getStringExtra("name");
        oper_page = intent.getStringExtra("oper_page");
        oper_name = intent.getStringExtra("oper_name");
        child_pay = intent.getStringExtra("child_pay");
        teenager_pay = intent.getStringExtra("teenager_pay");
        adult_pay = intent.getStringExtra("adult_pay");
        latitude = intent.getDoubleExtra("latitude", 0.0);
        longitude = intent.getDoubleExtra("longitude", 0.0);

        Log.d("total_datas", address+oper_tel+oper_name+oper_page+name+child_pay+adult_pay+teenager_pay+String.valueOf(latitude)+String.valueOf(longitude));

        showMap();

        websiteTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(oper_page));
                startActivity(intent);
            }
        });
        }
        public void showMap(){

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

            dataInput();
        }

        public void dataInput(){

            nameTv.setText(name);
            addressTv.setText(address);
            telTv.setText(oper_tel);
            websiteTv.setText(oper_page);
            adminTv.setText(oper_name);


            if(adult_pay.equals("P")) {
                adultTv.setText("미정");
            }else{
                adultTv.setText(adult_pay+"원");
            }

            if(teenager_pay.equals("P")) {
                tenagerTv.setText("미정");
            }else{
                tenagerTv.setText(teenager_pay+"원");
            }

            if(child_pay.equals("P")) {
                kidTv.setText("미정");
            }else{
                kidTv.setText(child_pay+"원");
            }

        }
}
