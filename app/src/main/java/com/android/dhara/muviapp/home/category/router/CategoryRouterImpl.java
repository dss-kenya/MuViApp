package com.android.dhara.muviapp.home.category.router;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.android.dhara.muviapp.home.collections.view.CollectionsFragment;
import com.android.dhara.muviapp.login.view.LoginActivity;
import com.android.dhara.muviapp.utils.ConstantIntentExtra;

import javax.inject.Inject;

public class CategoryRouterImpl implements CategoryRouter {
    private final FragmentActivity activity;

    @Inject
    public CategoryRouterImpl(final FragmentActivity activity) {
        this.activity = activity;
    }

    @Override
    public void loadCollectionsFragment(final long categoryId) {
        final Bundle bundle = new Bundle();
        bundle.putLong(ConstantIntentExtra.EXTRA_CATEGORY_ID, categoryId);
        CollectionsFragment.loadFragment(activity, bundle);
    }

    @Override
    public void navigateToLogin() {
        LoginActivity.startActivity(activity);
    }
}
