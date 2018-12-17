package com.example.multimedia.juniorseoul.Interface;

import com.example.multimedia.juniorseoul.Classess.KidsCafe;
import com.example.multimedia.juniorseoul.Classess.MuseumArtMemorial;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MuseumArtApiService {
    @GET("{operation}")
    Call<MuseumArtMemorial> getMuseumArtMemorialList(
            @Path("operation") String operation
    );
}
