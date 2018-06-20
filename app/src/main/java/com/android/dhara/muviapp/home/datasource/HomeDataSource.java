package com.android.dhara.muviapp.home.datasource;

import com.android.dhara.muviapp.network.Listener;
import com.android.dhara.muviapp.network.entity.CombinedUserResponse;

public interface HomeDataSource {
    void fetchUserInfo(String accessToken, Listener<CombinedUserResponse> listener);
}
