package com.android.dhara.muviapp.home.category.view;

import com.android.dhara.muviapp.home.model.CategoryModelAdapter;

public interface CategoryView {
    void initViews(CategoryModelAdapter modelAdapter, CategoryListener listener);

    void handleOnResume();

    void showProgress();

    void hideProgress();

    void showMessage(String message);

    void updateData(CategoryModelAdapter modelAdapter);

    void notifyChanges();
}
