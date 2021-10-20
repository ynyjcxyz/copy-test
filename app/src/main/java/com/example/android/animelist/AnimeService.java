package com.example.android.animelist;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AnimeService {

    @GET("v3/{query}")
    Call<AnimeDto> listRepos(@Path("query") String parameterQuery);
}