package com.example.multimedia.juniorseoul.Interface;

import com.example.multimedia.juniorseoul.Classess.NTinfo;
import com.example.multimedia.juniorseoul.Classess.Ninfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NinfoApiService {
    @GET("{state}/{t_id}")
    Call<Ninfo> getNinfoApi(
            @Path("state") String state,
            @Path("t_id") int t_id
    );
}
