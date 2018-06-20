package com.android.dhara.muviapp.home.model;

import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;

public interface CategoryModelAdapter {
    long getCategoryId(int position);

    @NonNull String getCategoryName(int position);

    @NonNull String getDescription(int position);

    int getCount();

    Drawable getBackgroundDrawable(int position);

    @ColorRes
    int getTextColor(int position);
}
