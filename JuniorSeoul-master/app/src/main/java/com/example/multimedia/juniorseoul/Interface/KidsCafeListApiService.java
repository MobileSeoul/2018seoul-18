package com.example.multimedia.juniorseoul.Interface;

import com.example.multimedia.juniorseoul.Classess.KidsCafe;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface KidsCafeListApiService {
    @GET("{state}")
    Call<KidsCafe> getKidsCafeList(
            @Path("state") String state
    );
}
