package com.example.multimedia.juniorseoul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class KidsCafeActivity extends AppCompatActivity {
    private String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids_cafe);

        id = getIntent().getStringExtra("id");


    }

    public void onButtonClick(View view) {
        Intent intent = new Intent(getApplicationContext(), KidsCafeListActivity.class);
        switch (view.getId()) {
            case R.id.kangnam :
                intent.putExtra("state", "X");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.joonglang :
                intent.putExtra("state", "A");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.joong :
                intent.putExtra("state", "B");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.eunpyung :
                intent.putExtra("state", "C");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.yongsan :
                intent.putExtra("state", "D");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.youngdeungpo :
                intent.putExtra("state", "E");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.yangcheon :
                intent.putExtra("state", "F");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.songpa :
                intent.putExtra("state", "G");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.sungbuk :
                intent.putExtra("state", "H");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.sungdong :
                intent.putExtra("state", "I");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.seocho :
                intent.putExtra("state", "J");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.seodaemun :
                intent.putExtra("state", "K");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.mapo :
                intent.putExtra("state", "L");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.dongjak :
                intent.putExtra("state", "M");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.dongdaemun :
                intent.putExtra("state", "N");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.dobong :
                intent.putExtra("state", "O");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.nowon :
                intent.putExtra("state", "P");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.keumcheon :
                intent.putExtra("state", "Q");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.kuro :
                intent.putExtra("state", "R");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.kwangjin :
                intent.putExtra("state", "S");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.kwanak :
                intent.putExtra("state", "T");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.kangseo :
                intent.putExtra("state", "U");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.kangbuk :
                intent.putExtra("state", "V");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.kangdong :
                intent.putExtra("state", "X");
                intent.putExtra("id", id);
                startActivity(intent);
                break;

        }
    }


}