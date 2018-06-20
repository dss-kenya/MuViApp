package com.android.dhara.muviapp.home.model;

import android.support.annotation.NonNull;

import com.android.dhara.muviapp.network.entity.CombinedUserResponse;

public class HomeDataModelCreator {
    @NonNull
    public static HomeDataModel create(@NonNull final CombinedUserResponse userInfo) {
        return new HomeDataModel.UserBuilder(userInfo).build();
    }
}
