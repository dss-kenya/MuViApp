package com.android.dhara.muviapp.home.model;

import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;

import com.android.dhara.muviapp.MuViApp;
import com.android.dhara.muviapp.R;
import com.android.dhara.muviapp.network.entity.Category;
import com.android.dhara.muviapp.utils.ListUtils;

import java.util.List;

public class CategoryModelAdapterImpl implements CategoryModelAdapter {
    private final List<Category> categoryList;
    private final long selectedCategoryId;

    public static CategoryModelAdapterImpl createFrom(final List<Category> categoryList,
                                                      final long selectedCategoryId) {
       return new CategoryModelAdapterImpl(categoryList, selectedCategoryId);
    }

    private CategoryModelAdapterImpl(final List<Category> categoryList,
                                     final long selectedCategoryId) {
        this.categoryList = categoryList;
        this.selectedCategoryId = selectedCategoryId;
    }

    @Override
    public long getCategoryId(final int position) {
        return ListUtils.isEmpty(categoryList) ? 0 : categoryList.get(position).getId();
    }

    @NonNull
    @Override
    public String getCategoryName(final int position) {
        return ListUtils.isEmpty(categoryList) ? "" : categoryList.get(position).getCategoryName();
    }

    @NonNull
    @Override
    public String getDescription(final int position) {
        return ListUtils.isEmpty(categoryList) ? "" : categoryList.get(position).getDescription();
    }

    @Override
    public int getCount() {
        return ListUtils.isEmpty(categoryList) ? 0 : categoryList.size();
    }

    @Override
    public Drawable getBackgroundDrawable(final int position) {
        return ContextCompat.getDrawable(MuViApp.getInstance(),
                isSelected(position) ? R.drawable.oval_background_selected : R.drawable.oval_background);
    }

    @ColorRes
    @Override
    public int getTextColor(final int position) {
        return isSelected(position) ? R.color.colorWhite : R.color.colorBlack;
    }

    private boolean isSelected(final int position) {
        return !ListUtils.isEmpty(categoryList) && categoryList.get(position).getId() == selectedCategoryId;
    }
}
