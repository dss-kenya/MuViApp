package com.android.dhara.muviapp.login.presenter;

import com.android.dhara.muviapp.login.router.LoginRouter;
import com.android.dhara.muviapp.login.view.LoginView;

public interface LoginPresenter {
    void handleOnCreate(LoginView view, LoginRouter router);

    void handleOnStart();
}
