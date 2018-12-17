package com.example.multimedia.juniorseoul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class TnActivity extends AppCompatActivity {

    private ImageView treasureImg, national_treasureImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tn);

        treasureImg = (ImageView)findViewById(R.id.treasureImg);
        national_treasureImg = (ImageView)findViewById(R.id.national_treasureImg);

        treasureImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TreasureActivity.class);
                startActivity(intent);
            }
        });

        national_treasureImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NationalTreasureActivity.class);
                startActivity(intent);
            }
        });

    }
}
