package com.example.multimedia.juniorseoul;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CultureDetailActivity extends AppCompatActivity {

    private String img_url, title, place, time, end_day, link, tel;
    private TextView titleTv, placeTv, timeTv, end_dayTv, linkTv, telTv;
    private ImageView img;
    private Typeface jua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_culture_detail);

        img_url = getIntent().getStringExtra("img_url");
        title = getIntent().getStringExtra("title");
        place = getIntent().getStringExtra("place");
        time = getIntent().getStringExtra("time");
        end_day = getIntent().getStringExtra("end_day");
        link = getIntent().getStringExtra("link");
        tel = getIntent().getStringExtra("tel");

        titleTv = (TextView)findViewById(R.id.culture_title);
        placeTv = (TextView)findViewById(R.id.culture_place);
        timeTv = (TextView)findViewById(R.id.culture_time);
        end_dayTv = (TextView)findViewById(R.id.culture_end_day);
        linkTv = (TextView)findViewById(R.id.culture_link);
        telTv = (TextView)findViewById(R.id.culture_tel);
        img = (ImageView)findViewById(R.id.culture_imageview);
        jua = Typeface.createFromAsset(this.getAssets(), "jua_ttf.ttf");

        titleTv.setText(title);
        titleTv.setTypeface(jua);

        placeTv.setText(place);
        placeTv.setTypeface(jua);

        timeTv.setText(time);
        end_dayTv.setText(end_day);
        linkTv.setText(link);
        telTv.setText( tel);

        linkTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                startActivity(intent);
            }
        });

        telTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:"+tel)));

            }
        });

        Thread mThread = new Thread(){
            @Override
            public void run(){
                try{
                    URL url = new URL(img_url);

                    HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                    conn.setDoInput(true);
                    conn.connect();

                    InputStream is = conn.getInputStream();

                    Bitmap bitmap = BitmapFactory.decodeStream(is);

                    img.setImageBitmap(bitmap);

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
