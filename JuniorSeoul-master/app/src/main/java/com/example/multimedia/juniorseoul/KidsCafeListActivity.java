package com.example.multimedia.juniorseoul;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.multimedia.juniorseoul.Adapter.KidsCafeListAdapter;
import com.example.multimedia.juniorseoul.Classess.CafeList;
import com.example.multimedia.juniorseoul.Classess.KidsCafe;
import com.example.multimedia.juniorseoul.Classess.KidsCafeListItem;
import com.example.multimedia.juniorseoul.Classess.ServiceGenerator;
import com.example.multimedia.juniorseoul.Interface.KidsCafeListApiService;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Url;

public class KidsCafeListActivity extends AppCompatActivity {

    private List<KidsCafeListItem> list = new ArrayList<KidsCafeListItem>();
    private ListView listview;
    private KidsCafeListAdapter adapter;
    private List<String> test  = new ArrayList<String>();
    private ArrayList<CafeList> cafeList;
    private static final String KIDS_CAFE_URL = "http://54.180.82.151:20000";
    private int count;
    private ProgressDialog progressDialog;
    private String id, origin_state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kid_cafe_list);

        Intent intent = getIntent();

        origin_state = intent.getStringExtra("state");
        id = intent.getStringExtra("id");

        setKidsCafeListAPI(origin_state);
        progressDialog = new ProgressDialog(KidsCafeListActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("진행중...");
        progressDialog.show();

    }
    private void setKidsCafeListAPI(String state){

        KidsCafeListApiService api = ServiceGenerator.getListApiService();

        Call<KidsCafe> call = api.getKidsCafeList(state);

        call.enqueue(new Callback<KidsCafe>() {
            @Override
            public void onResponse(Call<KidsCafe> call, Response<KidsCafe> response) {

                if(response.isSuccessful()){
                    cafeList = response.body().getCafeList();

                    for(count=0; count<cafeList.size(); count++){
                        Log.d("address", cafeList.get(count).getAddress());
                        Log.d("latitude", cafeList.get(count).getLatitude());
                        Log.d("longitude", cafeList.get(count).getLongitude());
                        Log.d("name", cafeList.get(count).getName());
                        Log.d("tell", cafeList.get(count).getTel());
                        Log.d("rating", String.valueOf(cafeList.get(count).getRating()));
                        Log.d("image_url", String.valueOf(cafeList.get(count).getImage_url()));
                        Log.d("kids_id", String.valueOf(cafeList.get(count).getKids_id()));

                        list.add(new KidsCafeListItem(cafeList.get(count).getName(), cafeList.get(count).getAddress(), (float)cafeList.get(count).getRating()));
                        test.add(KIDS_CAFE_URL+cafeList.get(count).getImage_url());

                        Thread mThread = new Thread(){
                            @Override
                            public void run(){
                                try{
                                    URL url = new URL(test.get(count));

                                    HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                                    conn.setDoInput(true);
                                    conn.connect();

                                    InputStream is = conn.getInputStream();

                                    Bitmap bitmap = BitmapFactory.decodeStream(is);
                                    list.get(count).setBitmap(bitmap);


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

                    listview = (ListView)findViewById(R.id.kids_cafe_listview);
                    listview.setFocusable(true);

                    adapter = new KidsCafeListAdapter();

                    listview.setAdapter(adapter);

                    for(int i=0; i<list.size(); i++){
                        adapter.addItem(list.get(i).getName(), list.get(i).getAddress(),list.get(i).getRate(), list.get(i).getBitmap());
                    }

                    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                            Intent detailItent = new Intent(getApplicationContext(), KidsCafeDetailActivity.class);

                            Log.d("position", Integer.toString(position));
                            detailItent.putExtra("id", id);
                            detailItent.putExtra("state", origin_state);
                            detailItent.putExtra("name", cafeList.get(position).getName());
                            detailItent.putExtra("address", cafeList.get(position).getAddress());
                            detailItent.putExtra("phoneNum", cafeList.get(position).getTel());
                            detailItent.putExtra("latitude", Double.parseDouble(cafeList.get(position).getLatitude()));
                            detailItent.putExtra("longitude", Double.parseDouble(cafeList.get(position).getLongitude()));
                            detailItent.putExtra("kids_id", cafeList.get(position).getKids_id());

                            startActivity(detailItent);
                        }
                    });
                    progressDialog.dismiss();
                }
                else{
                    Toast.makeText(getApplicationContext(),"response fail", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<KidsCafe> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"서버가 꺼져있습니다", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
