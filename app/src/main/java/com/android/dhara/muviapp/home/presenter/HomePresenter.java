package com.android.dhara.muviapp.home.presenter;

import com.android.dhara.muviapp.home.router.HomeRouter;
import com.android.dhara.muviapp.home.view.HomeView;

public interface HomePresenter {
    void handleOnCreate(HomeView view, HomeRouter router);

    void handleOnBackPress();
}
