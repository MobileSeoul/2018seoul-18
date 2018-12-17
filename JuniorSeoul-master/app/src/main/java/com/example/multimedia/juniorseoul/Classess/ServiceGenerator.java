package com.example.multimedia.juniorseoul.Classess;

import com.example.multimedia.juniorseoul.Interface.KidsCafeImageApiService;
import com.example.multimedia.juniorseoul.Interface.KidsCafeListApiService;
import com.example.multimedia.juniorseoul.Interface.KidsCafeReplyApiService;
import com.example.multimedia.juniorseoul.Interface.MuseumArtApiService;
import com.example.multimedia.juniorseoul.Interface.NTinfoApiService;
import com.example.multimedia.juniorseoul.Interface.NationalTreasureApiService;
import com.example.multimedia.juniorseoul.Interface.NinfoApiService;
import com.example.multimedia.juniorseoul.Interface.PlayCultureApiService;
import com.example.multimedia.juniorseoul.Interface.TreasureApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static final String KIDS_CAFE_URL = "http://54.180.82.151:20000/kids_cafe/";
    private static final String KIDS_CAFE_REPLY_URL = "http://54.180.82.151:20000/";
    private static final String MUSEUM_ART_URL = "http://54.180.82.151:20000/";
    private static final String NATIONAL_TREASURE_URL = "http://54.180.82.151:20000/trsr/NT/";
    private static final String TREASURE_URL = "http://54.180.82.151:20000/trsr/T/";
    private static final String PLAY_CULTURE_URL = "http://54.180.82.151:20000/play_culture/";

    private static Retrofit getKidsCafeListInstance(){
        return new Retrofit.Builder()
                .baseUrl(KIDS_CAFE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private static Retrofit getKidsCafeImageInstance(){
        return new Retrofit.Builder()
                .baseUrl(KIDS_CAFE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private static Retrofit getKidsCafeReplyInstance(){
        return new Retrofit.Builder()
                .baseUrl(KIDS_CAFE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private static Retrofit getMuseumArtInstance(){
        return new Retrofit.Builder()
                .baseUrl(MUSEUM_ART_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private static Retrofit getNationalTreasureInstance(){
        return new Retrofit.Builder()
                .baseUrl(NATIONAL_TREASURE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private static Retrofit getNTinfoInstance(){
        return new Retrofit.Builder()
                .baseUrl(NATIONAL_TREASURE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private static Retrofit getTreasureInstance(){
        return new Retrofit.Builder()
                .baseUrl(TREASURE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    private static Retrofit getTinfoInstance(){
        return new Retrofit.Builder()
                .baseUrl(TREASURE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    private static Retrofit getPlayCultureInstance(){
        return new Retrofit.Builder()
                .baseUrl(PLAY_CULTURE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    public static KidsCafeListApiService getListApiService(){
        return getKidsCafeListInstance().create(KidsCafeListApiService.class);
    }

    public static KidsCafeImageApiService getImageApiService(){
        return getKidsCafeImageInstance().create(KidsCafeImageApiService.class);
    }

    public static KidsCafeReplyApiService getReplyApiService(){
        return getKidsCafeReplyInstance().create(KidsCafeReplyApiService.class);
    }
    public static MuseumArtApiService getMuseumArtApiService(){
        return getMuseumArtInstance().create(MuseumArtApiService.class);
    }
    public static NationalTreasureApiService getNationalTreasureApiService(){
        return getNationalTreasureInstance().create(NationalTreasureApiService.class);
    }
    public static NTinfoApiService getNTinfoApiService(){
        return getNTinfoInstance().create(NTinfoApiService.class);
    }
    public static TreasureApiService getTreasureApiService(){
        return getTreasureInstance().create(TreasureApiService.class);
    }
    public static NinfoApiService getTinfoApiService(){
        return getTinfoInstance().create(NinfoApiService.class);
    }
    public static PlayCultureApiService getPlayCultureApiService(){
        return getPlayCultureInstance().create(PlayCultureApiService.class);
    }
}
