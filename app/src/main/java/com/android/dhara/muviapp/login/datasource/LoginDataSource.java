package com.android.dhara.muviapp.login.datasource;


import com.android.dhara.muviapp.network.Listener;
import com.android.dhara.muviapp.network.entity.LoginResponse;

public interface LoginDataSource {
    void login(String userName, String password, Listener<LoginResponse> listener);
}
