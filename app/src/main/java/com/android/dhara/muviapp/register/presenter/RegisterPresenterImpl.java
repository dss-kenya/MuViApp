package com.android.dhara.muviapp.register.presenter;

import com.android.dhara.muviapp.MuViApp;
import com.android.dhara.muviapp.R;
import com.android.dhara.muviapp.common.ResponseListener;
import com.android.dhara.muviapp.common.ViewInteractionListener;
import com.android.dhara.muviapp.network.ServiceError;
import com.android.dhara.muviapp.register.model.RegisterInteractor;
import com.android.dhara.muviapp.register.router.RegisterRouter;
import com.android.dhara.muviapp.register.view.RegisterView;

import javax.inject.Inject;

public class RegisterPresenterImpl implements RegisterPresenter, ViewInteractionListener, ResponseListener {
    @Inject
    RegisterInteractor registerInteractor;

    private RegisterView view;
    private RegisterRouter router;

    public RegisterPresenterImpl() {
        MuViApp.getInstance().getMuViAppComponent().inject(this);
    }

    @Override
    public void handleOnCreate(final RegisterView view, final RegisterRouter router) {
        this.view = view;
        this.router = router;
        this.view.initViews(this);
    }

    @Override
    public void handleOnBackPressed() {
        router.onBackPressed();
    }

    @Override
    public void onSignUpClicked() {
        view.showProgress();
        registerInteractor.register(view.getEmail(), view.getPassword(), this);
    }

    @Override
    public void onBackPressed() {
        handleOnBackPressed();
    }

    @Override
    public void onLoginClicked() {
        router.navigateToLogin();
    }

    @Override
    public void onSuccess() {
        view.hideProgress();
        view.showMessage(MuViApp.getInstance().getString(R.string.register_success));
    }

    @Override
    public void onError(final ServiceError error) {
        view.hideProgress();
        view.showMessage(error.getErrorMessage());
    }
}
