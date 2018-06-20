package com.android.dhara.muviapp.home.presenter;

import com.android.dhara.muviapp.MuViApp;
import com.android.dhara.muviapp.common.ResponseListener;
import com.android.dhara.muviapp.dagger2.injector.MuViAppInjector;
import com.android.dhara.muviapp.home.model.HomeInteractor;
import com.android.dhara.muviapp.home.router.HomeRouter;
import com.android.dhara.muviapp.home.view.HomeView;
import com.android.dhara.muviapp.home.view.ViewInteractionListener;
import com.android.dhara.muviapp.network.ServiceError;

import javax.inject.Inject;

public class HomePresenterImpl implements HomePresenter, ViewInteractionListener, ResponseListener {
    private HomeView view;
    private HomeRouter router;

    @Inject
    HomeInteractor interactor;

    @Inject
    public HomePresenterImpl() {
        MuViAppInjector.from(MuViApp.getInstance()).inject(this);
    }

    @Override
    public void handleOnCreate(final HomeView view, final HomeRouter router) {
        this.view = view;
        this.router = router;
        view.initViews(this);
        interactor.loadUserInfo(this);
        router.loadCategoriesFragment();
    }

    @Override
    public void handleOnBackPress() {
        if (!view.closeDrawerLayout()) {
            router.handleOnBackPress();
        }
    }

    @Override
    public void onSignedOut() {
        interactor.signOut();
        router.handleSignOut();
    }

    @Override
    public void onCategoriesClicked() {
        router.loadCategoriesFragment();
    }

    @Override
    public void onNavigationClicked() {
        view.handleOnNavigationClicked();
    }

    @Override
    public void onSuccess() {
        view.updateData(interactor.getDataModel());
    }

    @Override
    public void onError(final ServiceError error) {
        view.showMessage(error.getErrorMessage());
    }
}
