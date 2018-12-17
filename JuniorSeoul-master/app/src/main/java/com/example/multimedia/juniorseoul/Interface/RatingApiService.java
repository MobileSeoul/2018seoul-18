package com.example.multimedia.juniorseoul.Interface;

import com.example.multimedia.juniorseoul.Classess.RatingModel;
import com.example.multimedia.juniorseoul.Classess.ReplyResultModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RatingApiService {
    public static final String BASE_URL = "http://54.180.82.151:20000";
    @Headers("Content-Type: application/json")
    @POST("apply_rating")
    public Call<RatingModel> do_send_rating(@Body String body);
}
