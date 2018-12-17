package com.example.multimedia.juniorseoul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class CulturalEventActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cultural_event);

    }
    public void onButtonClick(View view) {
        Intent intent = new Intent(getApplicationContext(), CultureListActivity.class);
        switch (view.getId()) {
            case R.id.ckangnam :
                intent.putExtra("state", "X");
                startActivity(intent);
                break;
            case R.id.cjoonglang :
                intent.putExtra("state", "A");
                startActivity(intent);
                break;
            case R.id.cjoong :
                intent.putExtra("state", "B");
                startActivity(intent);
                break;
            case R.id.ceunpyung :
                intent.putExtra("state", "C");
                startActivity(intent);
                break;
            case R.id.cyongsan :
                intent.putExtra("state", "D");
                startActivity(intent);
                break;
            case R.id.cyoungdeungpo :
                intent.putExtra("state", "E");
                startActivity(intent);
                break;
            case R.id.cyangcheon :
                intent.putExtra("state", "F");
                startActivity(intent);
                break;
            case R.id.csongpa :
                intent.putExtra("state", "G");
                startActivity(intent);
                break;
            case R.id.csungbuk :
                intent.putExtra("state", "H");
                startActivity(intent);
                break;
            case R.id.csungdong :
                intent.putExtra("state", "I");
                startActivity(intent);
                break;
            case R.id.cseocho :
                intent.putExtra("state", "J");
                startActivity(intent);
                break;
            case R.id.cseodaemun :
                intent.putExtra("state", "K");
                startActivity(intent);
                break;
            case R.id.cmapo :
                intent.putExtra("state", "L");
                startActivity(intent);
                break;
            case R.id.cdongjak :
                intent.putExtra("state", "M");
                startActivity(intent);
                break;
            case R.id.cdongdaemun :
                intent.putExtra("state", "N");
                startActivity(intent);
                break;
            case R.id.cdobong :
                intent.putExtra("state", "O");
                startActivity(intent);
                break;
            case R.id.cnowon :
                intent.putExtra("state", "P");
                startActivity(intent);
                break;
            case R.id.ckeumcheon :
                intent.putExtra("state", "Q");
                startActivity(intent);
                break;
            case R.id.ckuro :
                intent.putExtra("state", "R");
                startActivity(intent);
                break;
            case R.id.ckwangjin :
                intent.putExtra("state", "S");
                startActivity(intent);
                break;
            case R.id.ckwanak :
                intent.putExtra("state", "T");
                startActivity(intent);
                break;
            case R.id.ckangseo :
                intent.putExtra("state", "U");
                startActivity(intent);
                break;
            case R.id.ckangbuk :
                intent.putExtra("state", "V");
                startActivity(intent);
                break;
            case R.id.ckangdong :
                intent.putExtra("state", "X");
                startActivity(intent);
                break;
            case R.id.cjongro :
                intent.putExtra("state", "Y");
                startActivity(intent);
                break;

        }
    }
}
