package com.example.multimedia.juniorseoul.Interface;

import com.example.multimedia.juniorseoul.Classess.NationalTreasure;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NationalTreasureApiService {
    @GET("{state}")
    Call<NationalTreasure> getNationalTreasure(
            @Path("state") String state
    );
}
