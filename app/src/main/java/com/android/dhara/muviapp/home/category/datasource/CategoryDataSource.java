package com.android.dhara.muviapp.home.category.datasource;

import com.android.dhara.muviapp.network.Listener;
import com.android.dhara.muviapp.network.entity.CategoryResponse;

public interface CategoryDataSource {
    void fetchCategories(String accessToken, Listener<CategoryResponse> listener);
}
