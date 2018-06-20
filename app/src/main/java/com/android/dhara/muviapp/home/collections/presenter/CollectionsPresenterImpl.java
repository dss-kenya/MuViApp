package com.android.dhara.muviapp.home.collections.presenter;

import com.android.dhara.muviapp.MuViApp;
import com.android.dhara.muviapp.common.ResponseListener;
import com.android.dhara.muviapp.home.collections.model.CollectionsInteractor;
import com.android.dhara.muviapp.home.collections.view.CollectionsView;
import com.android.dhara.muviapp.home.collections.model.CollectionsModelAdapterImpl;
import com.android.dhara.muviapp.home.collections.view.ViewInteractionListener;
import com.android.dhara.muviapp.network.ServiceError;

import javax.inject.Inject;

public class CollectionsPresenterImpl implements CollectionsPresenter, ResponseListener, ViewInteractionListener {
    private CollectionsView view;

    @Inject
    CollectionsInteractor interactor;

    public CollectionsPresenterImpl() {
        MuViApp.getInstance().getMuViAppComponent().inject(this);
    }

    @Override
    public void handleOnViewCreated(final long categoryId, final CollectionsView view) {
        this.view = view;
        view.initViews(CollectionsModelAdapterImpl.createFrom(interactor.getCollections()), this);
        interactor.setCategoryId(categoryId);
        view.showProgress();
        interactor.fetchCollections(this);
    }

    @Override
    public void handleOnDestroyView() {
       view.handleOnDestroy();
    }

    @Override
    public void onSuccess() {
        view.hideProgress();
        view.updateData(CollectionsModelAdapterImpl.createFrom(interactor.getCollections()));
    }

    @Override
    public void onError(final ServiceError error) {
        view.hideProgress();
        view.showMessage(error.getErrorMessage());
    }

    @Override
    public void onMuViCollectionClicked(final int position) {
        view.playVideo(position);
    }
}
