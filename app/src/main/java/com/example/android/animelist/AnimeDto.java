package com.example.android.animelist;

import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;
import com.ryanharter.auto.value.gson.GenerateTypeAdapter;

import java.util.List;

@GenerateTypeAdapter
@AutoValue
public abstract class AnimeDto {
    @SerializedName("request_hash")
    public abstract String requestHash();

    @SerializedName("request_cached")
    public abstract Boolean requestCached();

    @SerializedName("request_cache_expiry")
    public abstract String requestCacheExpiry();

    @SerializedName("results")
    public abstract List<AnimeInfo> animeList();

    public static AnimeDto create(String requestHash, Boolean requestCached, String requestCacheExpiry, List<AnimeInfo> animeList) {
        return new AutoValue_AnimeDto(requestHash, requestCached, requestCacheExpiry, animeList);
    }
}
