package com.android.dhara.muviapp.home.model;

import com.android.dhara.muviapp.MuViApp;
import com.android.dhara.muviapp.common.ResponseListener;
import com.android.dhara.muviapp.dagger2.injector.MuViAppInjector;
import com.android.dhara.muviapp.home.datasource.HomeDataSource;
import com.android.dhara.muviapp.network.Listener;
import com.android.dhara.muviapp.network.ServiceError;
import com.android.dhara.muviapp.network.entity.CombinedUserResponse;
import com.android.dhara.muviapp.utils.ConstantsSharedPrefs;
import com.android.dhara.muviapp.utils.SharedPrefHelper;

import javax.inject.Inject;

public class HomeInteractorImpl implements HomeInteractor {
    @Inject
    HomeDataSource dataSource;

    private CombinedUserResponse userInfo;

    public HomeInteractorImpl() {
        MuViAppInjector.from(MuViApp.getInstance()).inject(this);
    }

    @Override
    public void loadUserInfo(final ResponseListener listener) {
        final String accessToken = SharedPrefHelper.getString(ConstantsSharedPrefs.ACCESS_TOKEN, "");
        dataSource.fetchUserInfo(accessToken, new Listener<CombinedUserResponse>() {
            @Override
            public void onSuccess(final CombinedUserResponse response) {
                userInfo = response;
                listener.onSuccess();
            }

            @Override
            public void onError(final ServiceError error) {
                listener.onError(error);
            }
        });
    }

    @Override
    public HomeDataModel getDataModel() {
        return HomeDataModelCreator.create(userInfo);
    }

    @Override
    public void signOut() {
        SharedPrefHelper.remove(ConstantsSharedPrefs.ACCESS_TOKEN);
    }
}

