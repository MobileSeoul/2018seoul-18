package com.example.multimedia.juniorseoul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NationalTreasureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_national_treasure);
    }

    public void onButtonClick(View view) {
        Intent intent = new Intent(getApplicationContext(), TnListActivity.class);
        intent.putExtra("whichData", "nationalT");
        switch (view.getId()) {
            case R.id.kangnam :
                intent.putExtra("state", "X");
                startActivity(intent);
                break;
            case R.id.joong :
                intent.putExtra("state", "B");
                startActivity(intent);
                break;
            case R.id.yongsan :
                intent.putExtra("state", "D");
                startActivity(intent);
                break;
            case R.id.sungbuk :
                intent.putExtra("state", "H");
                startActivity(intent);
                break;
            case R.id.seocho :
                intent.putExtra("state", "J");
                startActivity(intent);
                break;
            case R.id.seodaemun :
                intent.putExtra("state", "K");
                startActivity(intent);
                break;
            case R.id.dongjak :
                intent.putExtra("state", "M");
                startActivity(intent);
                break;
            case R.id.kwangjin :
                intent.putExtra("state", "S");
                startActivity(intent);
                break;
            case R.id.kwanak :
                intent.putExtra("state", "T");
                startActivity(intent);
                break;
            case R.id.jongro :
                intent.putExtra("state", "Y");
                startActivity(intent);
                break;

        }
    }
}
