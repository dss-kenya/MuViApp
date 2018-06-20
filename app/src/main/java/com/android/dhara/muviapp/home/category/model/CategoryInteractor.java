package com.android.dhara.muviapp.home.category.model;

import com.android.dhara.muviapp.common.ResponseListener;
import com.android.dhara.muviapp.network.entity.Category;

import java.util.List;

public interface CategoryInteractor {
    void fetchCategories(ResponseListener listener);

    List<Category> getCategoryList();

    void setSelectedId(int position);

    long getSavedSelectedId();
}
