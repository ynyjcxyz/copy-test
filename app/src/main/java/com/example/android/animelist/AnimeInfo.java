package com.example.android.animelist;

import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;
import com.ryanharter.auto.value.gson.GenerateTypeAdapter;

@GenerateTypeAdapter
@AutoValue
public abstract class AnimeInfo {
    @Nullable
    @SerializedName("image_url")
    abstract String imgUrl();

    @Nullable
    @SerializedName("title")
    abstract String title();

    @Nullable
    @SerializedName("type")
    abstract String type();

    @Nullable
    @SerializedName("score")
    abstract String score();

    public static AnimeInfo create(String imgUrl, String title, String type,String score) {
        return new AutoValue_AnimeInfo(imgUrl, title, type, score);
    }
}
