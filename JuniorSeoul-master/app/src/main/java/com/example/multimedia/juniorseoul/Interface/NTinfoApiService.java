package com.example.multimedia.juniorseoul.Interface;

import com.example.multimedia.juniorseoul.Classess.NTinfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NTinfoApiService {
    @GET("{state}/{nt_id}")
    Call<NTinfo> getNTinfoApi(
            @Path("state") String state,
            @Path("nt_id") int nt_id
    );
}
