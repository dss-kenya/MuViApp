package com.android.dhara.muviapp.home.collections.presenter;

import com.android.dhara.muviapp.home.collections.view.CollectionsView;

public interface CollectionsPresenter {
    void handleOnViewCreated(long categoryId, CollectionsView view);

    void handleOnDestroyView();
}
