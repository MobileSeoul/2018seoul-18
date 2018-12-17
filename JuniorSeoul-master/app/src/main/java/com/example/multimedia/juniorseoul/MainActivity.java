package com.example.multimedia.juniorseoul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import kr.go.seoul.airquality.AirQualityButtonTypeA;

public class MainActivity extends AppCompatActivity {
    private AirQualityButtonTypeA typeAbtn;
    private String openApiKey = "4852536450646c6738336c4e7a7a50";
    private ImageView kidsCafe, museum_art, cultural_event_btn, tn_img;
    private String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = getIntent().getStringExtra("id");

        typeAbtn = (AirQualityButtonTypeA )findViewById(R.id.typeAbtn);
        typeAbtn.setOpenAPIKey(openApiKey);
        typeAbtn.setButtonImage(R.drawable.weather_check_img);

        kidsCafe = (ImageView)findViewById(R.id.kids_cafe);
        museum_art = (ImageView)findViewById(R.id.museum_art);
        cultural_event_btn = (ImageView)findViewById(R.id.cultural_event_btn);
        tn_img = (ImageView)findViewById(R.id.tnImg);

        kidsCafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), KidsCafeActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
        museum_art.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MuseumArtActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
        cultural_event_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CulturalEventActivity.class);
                startActivity(intent);
            }
        });
        tn_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TnActivity.class);
                startActivity(intent);
            }
        });
    }
}
