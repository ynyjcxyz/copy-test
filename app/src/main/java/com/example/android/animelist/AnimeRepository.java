package com.example.android.animelist;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ryanharter.auto.value.gson.GenerateTypeAdapter;
import java.io.IOException;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AnimeRepository {
    public static AnimeDto fetch(String parameterQuery) throws IOException {
        Gson enhancedGson = new GsonBuilder()
                .registerTypeAdapterFactory(GenerateTypeAdapter.FACTORY)
                .create();
        GsonConverterFactory factory = GsonConverterFactory.create(enhancedGson);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.jikan.moe/v3/search/")
                .addConverterFactory(factory)
                .build();
        AnimeService service = retrofit.create(AnimeService.class);
        return service.listRepos(parameterQuery).execute().body();
    }
}
