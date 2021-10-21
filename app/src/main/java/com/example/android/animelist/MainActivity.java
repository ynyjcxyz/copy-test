package com.example.android.animelist;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<AnimeInfo>> {
    public static final String LOG_TAG = MainActivity.class.getSimpleName();
    private InfoAdapter mAdapter;
    private static final String ANIME_LIST_URL =
            "https://api.jikan.moe/v3/search/anime?q=naruto";
    private static final int DATA_LOADER_ID = 1;
    private TextView emptyStateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdapter = new InfoAdapter(this, new ArrayList<AnimeInfo>());
        ListView AnimeInfoListView = (ListView) findViewById(R.id.list);

        emptyStateTextView = findViewById(R.id.empty_view);
        AnimeInfoListView.setEmptyView(emptyStateTextView);

        AnimeInfoListView.setAdapter(mAdapter);

        ConnectivityManager cm =
                (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            Log.i(LOG_TAG, "This is initLoader()");
            getSupportLoaderManager().initLoader(DATA_LOADER_ID, null, this).forceLoad();
        } else {
            ProgressBar prgBar = (ProgressBar) findViewById(R.id.loading_bar);
            prgBar.setVisibility(View.GONE);
            emptyStateTextView.setText("No Internet Connection...");
        }
    }

    @NonNull
    @Override
    public Loader<List<AnimeInfo>> onCreateLoader(int id, @Nullable Bundle bundle) {
        Log.i(LOG_TAG, "This is onCreateLoader() callback");
        return new InfoLoader(MainActivity.this, "naruto");
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<AnimeInfo>> loader, List<AnimeInfo> data) {
        ProgressBar prgBar = (ProgressBar) findViewById(R.id.loading_bar);
        prgBar.setVisibility(View.GONE);
        Log.i(LOG_TAG, "This is onLoadFinished() callback");
        mAdapter.clear();
        if (data != null && !data.isEmpty()) {
            mAdapter.addAll(data);
        } else {
            emptyStateTextView.setText("No Data can be found...");
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<AnimeInfo>> loader) {

    }
}