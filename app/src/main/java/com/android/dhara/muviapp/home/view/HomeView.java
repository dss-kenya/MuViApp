package com.android.dhara.muviapp.home.view;

import android.support.annotation.NonNull;
import android.view.MenuItem;

import com.android.dhara.muviapp.home.model.HomeDataModel;
import com.android.dhara.muviapp.home.collections.model.CollectionsModelAdapter;

public interface HomeView {
    void initViews(ViewInteractionListener listener);

    void updateData(@NonNull HomeDataModel dataModel);

    void showMessage(String message);

    boolean closeDrawerLayout();

    void handleOnNavigationClicked();

    void handleOnDrawerToggleUpdate(boolean isDrawerToggleIndicatorEnabled);
}
