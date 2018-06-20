package com.android.dhara.muviapp.home.category.presenter;

import com.android.dhara.muviapp.MuViApp;
import com.android.dhara.muviapp.home.category.model.CategoryInteractor;
import com.android.dhara.muviapp.home.category.router.CategoryRouter;
import com.android.dhara.muviapp.home.category.view.CategoryListener;
import com.android.dhara.muviapp.home.category.view.CategoryView;
import com.android.dhara.muviapp.common.ResponseListener;
import com.android.dhara.muviapp.home.model.CategoryModelAdapterImpl;
import com.android.dhara.muviapp.network.ServiceError;

import javax.inject.Inject;

public class CategoryPresenterImpl implements CategoryPresenter, CategoryListener, ResponseListener {
    @Inject
    CategoryInteractor interactor;

    private CategoryView view;
    private CategoryRouter router;

    public CategoryPresenterImpl() {
        MuViApp.getInstance().getMuViAppComponent().inject(this);
    }

    @Override
    public void handleOnViewCreated(final CategoryView view, final CategoryRouter router) {
        this.router = router;
        this.view = view;
        view.initViews(CategoryModelAdapterImpl.createFrom(interactor.getCategoryList(),
                interactor.getSavedSelectedId()), this);
        view.showProgress();
        interactor.fetchCategories(this);
    }

    @Override
    public void handleOnResume() {
        view.handleOnResume();
    }

    @Override
    public void onCategoryClicked(final int position) {
        interactor.setSelectedId(position);
        view.notifyChanges();
        router.loadCollectionsFragment(interactor.getSavedSelectedId());
    }

    @Override
    public void onSuccess() {
        view.hideProgress();
        view.updateData(CategoryModelAdapterImpl.createFrom(interactor.getCategoryList(),
                interactor.getSavedSelectedId()));
    }

    @Override
    public void onError(final ServiceError error) {
        view.hideProgress();

        view.showMessage(error.getErrorMessage());

        // this should be handled using error codes
        if (error.getErrorMessage().contains("Authentication")) {
            router.navigateToLogin();
        }
    }
}
