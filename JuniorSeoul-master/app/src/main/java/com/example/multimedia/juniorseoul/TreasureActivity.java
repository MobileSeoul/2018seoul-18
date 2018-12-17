package com.example.multimedia.juniorseoul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TreasureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treasure);
    }
    public void onButtonClick(View view) {
        Intent intent = new Intent(getApplicationContext(), TnListActivity.class);
        intent.putExtra("whichData", "T");
        switch (view.getId()) {
            case R.id.tjoong :
                intent.putExtra("state", "B");
                startActivity(intent);
                break;
            case R.id.teunpyung :
                intent.putExtra("state", "C");
                startActivity(intent);
                break;
            case R.id.tyongsan :
                intent.putExtra("state", "D");
                startActivity(intent);
                break;
            case R.id.tsongpa :
                intent.putExtra("state", "G");
                startActivity(intent);
                break;
            case R.id.tsungbuk :
                intent.putExtra("state", "H");
                startActivity(intent);
                break;
            case R.id.tseocho :
                intent.putExtra("state", "J");
                startActivity(intent);
                break;
            case R.id.tseodamun :
                intent.putExtra("state", "K");
                startActivity(intent);
                break;
            case R.id.tmapo :
                intent.putExtra("state", "L");
                startActivity(intent);
                break;
            case R.id.tdongjak :
                intent.putExtra("state", "M");
                startActivity(intent);
                break;
            case R.id.tdongdaemun :
                intent.putExtra("state", "N");
                startActivity(intent);
                break;
            case R.id.tnowon :
                intent.putExtra("state", "P");
                startActivity(intent);
                break;
            case R.id.tkwangjin :
                intent.putExtra("state", "S");
                startActivity(intent);
                break;
            case R.id.tkwanak :
                intent.putExtra("state", "T");
                startActivity(intent);
                break;
            case R.id.tkangsoe :
                intent.putExtra("state", "U");
                startActivity(intent);
                break;
            case R.id.tkangbuk :
                intent.putExtra("state", "V");
                startActivity(intent);
                break;
            case R.id.tkangnam :
                intent.putExtra("state", "X");
                startActivity(intent);
                break;
            case R.id.tjongro :
                intent.putExtra("state", "Y");
                startActivity(intent);
                break;

        }
    }
}
