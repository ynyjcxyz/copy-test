package com.example.android.animelist;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AnimeService {

    @GET("anime")
    Call<AnimeDto> listRepos(@Query("q") String parameterQuery);
}