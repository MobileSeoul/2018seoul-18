package com.example.multimedia.juniorseoul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.multimedia.juniorseoul.Adapter.CultureListAdapter;
import com.example.multimedia.juniorseoul.Classess.PlayCulture;
import com.example.multimedia.juniorseoul.Classess.PlayCultureList;
import com.example.multimedia.juniorseoul.Classess.ServiceGenerator;
import com.example.multimedia.juniorseoul.Interface.PlayCultureApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CultureListActivity extends AppCompatActivity {
    private ListView listview;
    private String state_cd;
    private CultureListAdapter adapter;
    private ArrayList<PlayCultureList> playCultureList;
    private int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_culture_list);

        state_cd = getIntent().getStringExtra("state");

        listview = (ListView)findViewById(R.id.culture_listview);

        adapter = new CultureListAdapter();

        setCultureListAPI(state_cd);

    }
    public void setCultureListAPI(final String state){
        PlayCultureApiService api = ServiceGenerator.getPlayCultureApiService();

        Call<PlayCulture> call = api.getPlayCulture(state);

        call.enqueue(new Callback<PlayCulture>() {
            @Override
            public void onResponse(Call<PlayCulture> call, Response<PlayCulture> response) {

                if (response.isSuccessful()) {
                    playCultureList = response.body().getPlayCultureList();

                    for(count=0; count<playCultureList.size(); count++){
                        adapter.addItem(playCultureList.get(count).getTitle(), playCultureList.get(count).getPlace(), playCultureList.get(count).getOpen_time());
                    }

                    listview.setAdapter(adapter);

                    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                            Intent intent = new Intent(getApplicationContext(), CultureDetailActivity.class);

                            intent.putExtra("img_url", playCultureList.get(position).getImage_url());
                            intent.putExtra("title", playCultureList.get(position).getTitle());
                            intent.putExtra("place", playCultureList.get(position).getPlace());
                            intent.putExtra("time", playCultureList.get(position).getOpen_time());
                            intent.putExtra("end_day", playCultureList.get(position).getEnd_day());
                            intent.putExtra("link", playCultureList.get(position).getLink());
                            intent.putExtra("tel", playCultureList.get(position).getTel_num());

                            startActivity(intent);
                        }
                    });

                }
            }


            @Override
            public void onFailure(Call<PlayCulture> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "서버가 꺼져있습니다", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
