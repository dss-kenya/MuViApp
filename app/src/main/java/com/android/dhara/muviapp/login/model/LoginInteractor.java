package com.android.dhara.muviapp.login.model;

import com.android.dhara.muviapp.common.ResponseListener;

public interface LoginInteractor {
    void login(String userName, String password, ResponseListener listener);

    boolean isSessionValid();
}
