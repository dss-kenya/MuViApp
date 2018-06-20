package com.android.dhara.muviapp.login.view;

import com.android.dhara.muviapp.common.ViewInteractionListener;

public interface LoginView {
    void initViews(ViewInteractionListener listener);

    void showErrorMessage(String errorMessage);

    void showProgress();

    void hideProgress();

    String getUserName();

    String getPassword();
}
