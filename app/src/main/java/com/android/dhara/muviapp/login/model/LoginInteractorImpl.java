package com.android.dhara.muviapp.login.model;

import android.text.TextUtils;

import com.android.dhara.muviapp.MuViApp;
import com.android.dhara.muviapp.common.ResponseListener;
import com.android.dhara.muviapp.dagger2.injector.MuViAppInjector;
import com.android.dhara.muviapp.login.datasource.LoginDataSource;
import com.android.dhara.muviapp.network.Listener;
import com.android.dhara.muviapp.network.ServiceError;
import com.android.dhara.muviapp.network.entity.LoginResponse;
import com.android.dhara.muviapp.utils.ConstantsSharedPrefs;
import com.android.dhara.muviapp.utils.MuViAppLog;
import com.android.dhara.muviapp.utils.SharedPrefHelper;

import javax.inject.Inject;

public class LoginInteractorImpl implements LoginInteractor {
    @Inject
    LoginDataSource dataSource;

    @Inject
    MuViAppLog logger;

    public LoginInteractorImpl() {
        MuViAppInjector.from(MuViApp.getInstance()).inject(this);
    }

    @Override
    public void login(final String userName, final String password, final ResponseListener listener) {
        dataSource.login(userName, password, new Listener<LoginResponse>() {
            @Override
            public void onSuccess(final LoginResponse response) {
                SharedPrefHelper.putString(ConstantsSharedPrefs.ACCESS_TOKEN, response.getAccessToken());
                listener.onSuccess();
            }

            @Override
            public void onError(final ServiceError error) {
                listener.onError(error);
            }
        });
    }

    @Override
    public boolean isSessionValid() {
        return !TextUtils.isEmpty(SharedPrefHelper.getString(ConstantsSharedPrefs.ACCESS_TOKEN, ""));
    }
}
