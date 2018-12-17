package com.example.multimedia.juniorseoul;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import uk.co.senab.photoview.PhotoViewAttacher;

public class KidsCafeImageActivity extends AppCompatActivity {

    private ImageView img;
    private String img_url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids_cafe_image);

        /*byte[] bytes = getIntent().getByteArrayExtra("bitmap");
        Bitmap bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);*/

        img_url = getIntent().getStringExtra("image_url");

        Log.d("iaimg_url", img_url);

        img = (ImageView)findViewById(R.id.detail_image);

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

        PhotoViewAttacher mAttacher = new PhotoViewAttacher(img);

    }
}
