package com.example.multimedia.juniorseoul.Interface;

import com.example.multimedia.juniorseoul.Classess.Treasure;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TreasureApiService {
    @GET("{state}")
    Call<Treasure> getTreasure(
            @Path("state") String state
    );
}
