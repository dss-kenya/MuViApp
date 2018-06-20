package com.android.dhara.muviapp.home.collections.model;

import android.support.annotation.NonNull;

public interface CollectionsModelAdapter {
    @NonNull String getMuViName(int position);

    @NonNull String getMuViDesc(int position);

    @NonNull String getVideoPath(int position);

    int getNumberOfViews(int position);

    int getCount();
}
