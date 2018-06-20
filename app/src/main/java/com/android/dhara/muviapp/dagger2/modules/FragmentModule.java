package com.android.dhara.muviapp.dagger2.modules;

import android.content.Context;
import android.support.v4.app.FragmentActivity;

import com.android.dhara.muviapp.home.category.presenter.CategoryPresenter;
import com.android.dhara.muviapp.home.category.presenter.CategoryPresenterImpl;
import com.android.dhara.muviapp.home.category.router.CategoryRouter;
import com.android.dhara.muviapp.home.category.router.CategoryRouterImpl;
import com.android.dhara.muviapp.home.category.view.CategoryView;
import com.android.dhara.muviapp.home.category.view.CategoryViewImpl;
import com.android.dhara.muviapp.dagger2.injection.PerFragment;
import com.android.dhara.muviapp.dagger2.scope.FragmentScope;
import com.android.dhara.muviapp.home.collections.presenter.CollectionsPresenter;
import com.android.dhara.muviapp.home.collections.presenter.CollectionsPresenterImpl;
import com.android.dhara.muviapp.home.collections.view.CollectionsView;
import com.android.dhara.muviapp.home.collections.view.CollectionsViewImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {
    private FragmentActivity activity;

    public FragmentModule(FragmentActivity activity) {
        this.activity = activity;
    }

    @Provides
    FragmentActivity provideActivity() {
        return activity;
    }

    @Provides
    @FragmentScope
    Context providesContext() {
        return activity;
    }

    @Provides
    @PerFragment
    public CategoryPresenter provideCategoryPresenter() {
        return new CategoryPresenterImpl();
    }

    @Provides
    @PerFragment
    public CategoryView provideCategoryView() {
        return new CategoryViewImpl(activity);
    }

    @Provides
    @PerFragment
    public CategoryRouter provideCategoryRouter() {
        return new CategoryRouterImpl(activity);
    }

    @Provides
    @PerFragment
    public CollectionsPresenter provideCollectionsPresenter() {
        return new CollectionsPresenterImpl();
    }

    @Provides
    @PerFragment
    public CollectionsView provideCollectionsView() {
        return new CollectionsViewImpl(activity);
    }
}
