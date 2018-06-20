package com.android.dhara.muviapp.home.collections.view;

import com.android.dhara.muviapp.home.collections.model.CollectionsModelAdapter;

public interface CollectionsView {
    void initViews(CollectionsModelAdapter modelAdapter, ViewInteractionListener listener);

    void updateData(CollectionsModelAdapter modelAdapter);

    void showProgress();

    void hideProgress();

    void showMessage(String message);

    void playVideo(int position);

    void handleOnDestroy();
}
