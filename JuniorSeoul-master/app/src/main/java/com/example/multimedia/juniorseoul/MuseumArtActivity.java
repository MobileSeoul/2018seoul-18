package com.example.multimedia.juniorseoul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MuseumArtActivity extends AppCompatActivity {

    private ImageView museum, art, memorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museum_art);

        museum = (ImageView)findViewById(R.id.museumIv);
        art = (ImageView)findViewById(R.id.artIv);
        memorial = (ImageView)findViewById(R.id.memorialIv);

        museum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MuseumArtListActivity.class);
                intent.putExtra("which_data", 0);
                startActivity(intent);
            }
        });

        art.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MuseumArtListActivity.class);
                intent.putExtra("which_data", 1);
                startActivity(intent);
            }
        });

        memorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MuseumArtListActivity.class);
                intent.putExtra("which_data", 2);
                startActivity(intent);
            }
        });

    }
}
