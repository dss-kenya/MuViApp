package com.android.dhara.muviapp.home.model;

import com.android.dhara.muviapp.common.ResponseListener;

public interface HomeInteractor {
    void loadUserInfo(ResponseListener listener);

    HomeDataModel getDataModel();

    void signOut();
}
