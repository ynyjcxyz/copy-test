package com.example.android.animelist;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;
import java.io.IOException;
import java.util.List;

public class InfoLoader extends AsyncTaskLoader<List<AnimeInfo>> {
    public static final String LOG_TAG = AsyncTaskLoader.class.getSimpleName();
    private final String query;

    public InfoLoader(@NonNull Context context, String url) {
        super(context);
        String[] newStr = url.split("=");
        query = newStr[1];
    }

    @Override
    protected void onStartLoading() {
        Log.i(LOG_TAG,"This is onStartLoading() method");
        forceLoad();
    }

    @Nullable
    @Override
    public List<AnimeInfo> loadInBackground() {
        Log.i(LOG_TAG,"This is loadInBackground() method");
        try{
            AnimeDto animeDto = AnimeRepository.fetch(query);
            return animeDto.animeList();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
