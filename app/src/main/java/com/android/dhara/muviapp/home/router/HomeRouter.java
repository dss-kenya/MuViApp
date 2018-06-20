package com.android.dhara.muviapp.home.router;

public interface HomeRouter {
    void close();

    void handleOnBackPress();

    void handleSignOut();

    void loadCategoriesFragment();
}
