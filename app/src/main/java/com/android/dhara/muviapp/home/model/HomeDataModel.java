package com.android.dhara.muviapp.home.model;

import android.support.annotation.NonNull;

import com.android.dhara.muviapp.network.entity.CombinedUserResponse;

public class HomeDataModel {
    private CombinedUserResponse user;

    public HomeDataModel(final CombinedUserResponse user) {
        this.user = user;
    }

    public CombinedUserResponse getUser() {
        return user;
    }

    static class UserBuilder {
        private final CombinedUserResponse user;

        public UserBuilder(@NonNull final CombinedUserResponse user) {
            this.user = user;
        }

        public HomeDataModel build() {
            return new HomeDataModel(user);
        }
    }
}
