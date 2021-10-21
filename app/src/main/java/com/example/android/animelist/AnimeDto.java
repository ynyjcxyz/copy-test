package com.example.android.animelist;

import androidx.annotation.Nullable;
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

  @Nullable
  @SerializedName("results")
  public abstract List<AnimeInfo> animeList();

}
