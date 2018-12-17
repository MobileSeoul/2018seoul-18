package com.example.multimedia.juniorseoul;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.multimedia.juniorseoul.Adapter.PagerAdapter;
import com.example.multimedia.juniorseoul.Classess.ImageList;
import com.example.multimedia.juniorseoul.Classess.KidsCafeImage;
import com.example.multimedia.juniorseoul.Classess.KidsCafeReply;
import com.example.multimedia.juniorseoul.Classess.ParcelBitmapList;
import com.example.multimedia.juniorseoul.Classess.RatingModel;
import com.example.multimedia.juniorseoul.Classess.ReplyList;
import com.example.multimedia.juniorseoul.Classess.ReplyResultModel;
import com.example.multimedia.juniorseoul.Classess.ServiceGenerator;
import com.example.multimedia.juniorseoul.Interface.KidsCafeImageApiService;
import com.example.multimedia.juniorseoul.Interface.KidsCafeReplyApiService;
import com.example.multimedia.juniorseoul.Interface.RatingApiService;
import com.example.multimedia.juniorseoul.Interface.ReplyPoint;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import static com.kakao.util.maps.helper.Utility.getPackageInfo;

public class KidsCafeDetailActivity extends AppCompatActivity {
    private MapView mapView;
    private TextView nameTv, addressTv, phoneNumTv;
    private String id, state;
    private ArrayList<ImageList> imageList;
    private ArrayList<ReplyList> replyList;
    private static final String KIDS_CAFE_URL = "http://54.180.82.151:20000";
    private int count, kids_id;
    private ArrayList<String> url_data;
    private TabLayout tabLayout;
    private ArrayList<String> info;
    private ProgressDialog progressDialog;
    private RatingBar ratingBar, yratingBar;
    private Button rating_send_btn;
    private FrameLayout yFrameLayout, nFrameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids_cafe_detail);

        ratingBar = (RatingBar) findViewById(R.id.kids_cafe_detail_ratingbar);
        yratingBar = (RatingBar)findViewById(R.id.ykids_cafe_detail_ratingbar);
        rating_send_btn = (Button) findViewById(R.id.nrating_send_btn);
        yFrameLayout = (FrameLayout) findViewById(R.id.yFrameLayout);
        nFrameLayout = (FrameLayout) findViewById(R.id.nFrameLayout);

        yFrameLayout.setVisibility(View.GONE);
        nFrameLayout.setVisibility(View.GONE);

        //getKeyHash(this);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        state = intent.getStringExtra("state");
        String name = intent.getStringExtra("name");
        String address = intent.getStringExtra("address");
        String phoneNum = intent.getStringExtra("phoneNum");
        double latitude = intent.getDoubleExtra("latitude", 0.0);
        double longitude = intent.getDoubleExtra("longitude", 0.0);
        kids_id = intent.getIntExtra("kids_id", 0);

        Log.d("latitude test", Double.toString(latitude));
        Log.d("kids_id test", Integer.toString(kids_id));
        Log.d("user_id test", id);

        // 정보 프래그먼트 데이터 세팅
        info = new ArrayList<>();
        info.add(name);
        info.add(address);
        info.add(phoneNum);


        showMap(name, latitude, longitude);

        progressDialog = new ProgressDialog(KidsCafeDetailActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("진행중...");
        progressDialog.show();

        Handler delayHandler1 = new Handler();
        delayHandler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                setKidsCafeReplyListAPI(state, kids_id);
            }
        }, 600);

        Handler delayHandler3 = new Handler();
        delayHandler3.postDelayed(new Runnable() {
            @Override
            public void run() {
                setKidsCafeImageListAPI(state, kids_id);
            }
        }, 500);


        Handler delayHandler2 = new Handler();
        delayHandler2.postDelayed(new Runnable() {
            @Override
            public void run() {
                final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
                final PagerAdapter adapter = new PagerAdapter
                        (getSupportFragmentManager(), tabLayout.getTabCount(), info,  replyList, kids_id, id, url_data);

                for(int i=0; i<url_data.size(); i++){
                    Log.d("daimg_url", url_data.get(i));
                }
                Log.d("pager 호출", "pager 호출");
                viewPager.setAdapter(adapter);
                viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
                tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        viewPager.setCurrentItem(tab.getPosition());
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {

                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {

                    }
                });
                progressDialog.dismiss();
            }
        }, 3500);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("정보"));
        tabLayout.addTab(tabLayout.newTab().setText("이미지"));
        tabLayout.addTab(tabLayout.newTab().setText("댓글"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        rating_send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double rating = (double) ratingBar.getRating();
                Log.d("rating", String.valueOf(rating));

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(ReplyPoint.BASE_URL)
                        .addConverterFactory(ScalarsConverterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                RatingApiService ratingApiService = retrofit.create(RatingApiService.class);
                try {
                    JSONObject paramObject = new JSONObject();
                    paramObject.put("kid_id", kids_id);
                    paramObject.put("user_id", id);
                    paramObject.put("rating", rating);

                    Call<RatingModel> userCall = ratingApiService.do_send_rating(paramObject.toString());
                    userCall.enqueue(new Callback<RatingModel>() {
                        @Override
                        public void onResponse(Call<RatingModel> call, Response<RatingModel> response) {

                        }

                        @Override
                        public void onFailure(Call<RatingModel> call, Throwable t) {

                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Toast.makeText(getApplicationContext(), "별점이 기록되었습니다", Toast.LENGTH_LONG).show();
                nFrameLayout.setVisibility(View.GONE);
                yFrameLayout.setVisibility(View.VISIBLE);
                yratingBar.setRating(ratingBar.getRating());
            }
        });

    }
    public void showMap(String name, double latitude, double longitude){
        Log.d("hashkey", getKeyHash(this));
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

    public static String getKeyHash(final Context context) {
        PackageInfo packageInfo = getPackageInfo(context, PackageManager.GET_SIGNATURES);
        if (packageInfo == null)
            return null;

        for (Signature signature : packageInfo.signatures) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                return android.util.Base64.encodeToString(md.digest(), android.util.Base64.NO_WRAP);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void setKidsCafeImageListAPI(final String state, final int kids_id){

        KidsCafeImageApiService api = ServiceGenerator.getImageApiService();

        Call<KidsCafeImage> call = api.getKidsCafeImageList(state, kids_id);

        call.enqueue(new Callback<KidsCafeImage>() {
            @Override
            public void onResponse(Call<KidsCafeImage> call, Response<KidsCafeImage> response) {

                if(response.isSuccessful()){
                    imageList = response.body().getImageList();
                    url_data = new ArrayList<String>();

                    for(count=0; count<imageList.size(); count++){
                        Log.d("kidscafe image url", imageList.get(count).getImage_url());


                        url_data.add(KIDS_CAFE_URL+imageList.get(count).getImage_url());

                        Thread mThread = new Thread(){
                            @Override
                            public void run(){
                                try{
                                    URL url = new URL(url_data.get(count));

                                    HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                                    conn.setDoInput(true);
                                    conn.connect();

                                    InputStream is = conn.getInputStream();

                                    Bitmap bitmap = BitmapFactory.decodeStream(is);
                                    Log.d("bitmap 추가", "비트맵" + Integer.toString(count)+ "추가");


                                }catch (MalformedURLException e){
                                    e.printStackTrace();
                                }catch (IOException e){
                                    e.printStackTrace();
                                }

                            }
                        };

                        mThread.start();

                        try{
                            mThread.join();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }

                    }

                }
                else{
                    Toast.makeText(getApplicationContext(),"response fail", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<KidsCafeImage> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"서버가 꺼져있습니다", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }

    public void setKidsCafeReplyListAPI(String state, int kids_id){

        final KidsCafeReplyApiService replyApi = ServiceGenerator.getReplyApiService();
        Call<KidsCafeReply> replyCall = replyApi.getReplyApiService(state, kids_id, id);

        replyCall.enqueue(new Callback<KidsCafeReply>() {
            @Override
            public void onResponse(Call<KidsCafeReply> call, Response<KidsCafeReply> response) {

                if(response.isSuccessful()){
                    replyList = response.body().getReplyList();
                    boolean flag = response.body().isFlag();
                    if(flag==true){

                        Log.d("flag", "있음");
                        float rating = (float)response.body().getRating();

                        yratingBar.setRating(rating);
                        yratingBar.setIsIndicator(true);

                        Log.d("hasrating", String.valueOf(rating));

                        yFrameLayout.setVisibility(View.VISIBLE);

                        Button fixBtn = (Button)findViewById(R.id.yrating_send_btn);

                        fixBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                nFrameLayout.setVisibility(View.VISIBLE);
                                yFrameLayout.setVisibility(View.GONE);
                            }
                        });

                    }else{
                        Log.d("flag", "없음");
                        nFrameLayout.setVisibility(View.VISIBLE);

                    }
                }

                else{
                    Toast.makeText(getApplicationContext(),"response fail", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<KidsCafeReply> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"서버가 꺼져있습니다", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
