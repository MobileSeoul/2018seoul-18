package com.example.multimedia.juniorseoul.Interface;

import com.example.multimedia.juniorseoul.Classess.KidsCafeImage;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface KidsCafeImageApiService {
    @GET("{state}/{kids_id}/images")
    Call<KidsCafeImage> getKidsCafeImageList(
            @Path("state") String state,
            @Path("kids_id") int kids_id
    );
}
