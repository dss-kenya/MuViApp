package com.android.dhara.muviapp.home.router;

import android.support.v7.app.AppCompatActivity;

import com.android.dhara.muviapp.home.category.view.CategoryFragment;
import com.android.dhara.muviapp.login.view.LoginActivity;

import javax.inject.Inject;

public class HomeRouterImpl implements HomeRouter {
    private final AppCompatActivity activity;

    @Inject
    public HomeRouterImpl(final AppCompatActivity activity) {
        this.activity = activity;
    }

    @Override
    public void close() {
        activity.finish();
    }

    @Override
    public void handleOnBackPress() {
        close();
    }

    @Override
    public void handleSignOut() {
        LoginActivity.startActivity(activity);
        close();
    }

    @Override
    public void loadCategoriesFragment() {
        CategoryFragment.loadFragment(activity);
    }
}
