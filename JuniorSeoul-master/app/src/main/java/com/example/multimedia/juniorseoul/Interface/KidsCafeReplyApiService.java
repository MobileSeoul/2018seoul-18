package com.example.multimedia.juniorseoul.Interface;

import com.example.multimedia.juniorseoul.Classess.KidsCafeReply;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface KidsCafeReplyApiService {
    @GET("{state}/{kids_id}/{user_id}/comments")
    Call<KidsCafeReply> getReplyApiService(
            @Path("state") String state,
            @Path("kids_id") int kids_id,
            @Path("user_id") String user_id
    );
}
