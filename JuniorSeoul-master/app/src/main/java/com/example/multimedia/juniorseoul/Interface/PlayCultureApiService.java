package com.example.multimedia.juniorseoul.Interface;

import com.example.multimedia.juniorseoul.Classess.PlayCulture;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PlayCultureApiService {
    @GET("{state}")
    Call<PlayCulture> getPlayCulture(
            @Path("state") String state
    );
}
