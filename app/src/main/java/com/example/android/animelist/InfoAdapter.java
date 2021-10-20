package com.example.android.animelist;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class InfoAdapter extends ArrayAdapter<AnimeInfo> {
    public InfoAdapter(Activity context, List<AnimeInfo> animeInfo) {
        super(context, 0, animeInfo);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_detail, parent, false);
        }
        AnimeInfo currentAnimeInfo = getItem(position);

        ImageView imageView = listItemView.findViewById(R.id.img);
        String imgUrl = currentAnimeInfo.imgUrl();
        Glide.with(parent).load(imgUrl).error(R.drawable.no_data).into(imageView);

        TextView title = listItemView.findViewById(R.id.title);
        title.setText(currentAnimeInfo.title());

        TextView type = listItemView.findViewById(R.id.type);
        type.setText(currentAnimeInfo.type());

        TextView score = listItemView.findViewById(R.id.score);
        score.setText(currentAnimeInfo.score());

        return listItemView;
    }
}
