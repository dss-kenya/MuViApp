package com.android.dhara.muviapp.login.presenter;

import com.android.dhara.muviapp.MuViApp;
import com.android.dhara.muviapp.common.ResponseListener;
import com.android.dhara.muviapp.login.model.LoginInteractor;
import com.android.dhara.muviapp.login.router.LoginRouter;
import com.android.dhara.muviapp.login.view.LoginView;
import com.android.dhara.muviapp.common.ViewInteractionListener;
import com.android.dhara.muviapp.network.ServiceError;

import javax.inject.Inject;

public class LoginPresenterImpl implements LoginPresenter, ViewInteractionListener, ResponseListener {
    @Inject
    LoginInteractor loginInteractor;

    private LoginView view;
    private LoginRouter router;

    public LoginPresenterImpl() {
        MuViApp.getInstance().getMuViAppComponent().inject(this);
    }

    @Override
    public void handleOnCreate(final LoginView view, final LoginRouter router) {
        this.view = view;
        this.router = router;
        this.view.initViews(this);
    }

    @Override
    public void handleOnStart() {
        if (loginInteractor.isSessionValid()) {
            // user is already signed in
            // update user's UI and lead to HomeActivity
            router.navigateToHome();
        }
    }

    @Override
    public void onLoginClicked() {
        view.showProgress();
        loginInteractor.login(view.getUserName(), view.getPassword(), this);
    }

    @Override
    public void onSignUpClicked() {
        router.navigateToRegister();
    }

    @Override
    public void onBackPressed() {
        // do nothing
    }

    @Override
    public void onSuccess() {
        view.hideProgress();
        router.navigateToHome();
    }

    @Override
    public void onError(final ServiceError error) {
        view.hideProgress();
        view.showErrorMessage(error.getErrorMessage());
    }
}
