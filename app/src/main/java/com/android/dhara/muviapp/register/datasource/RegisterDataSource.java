package com.android.dhara.muviapp.register.datasource;


import com.android.dhara.muviapp.network.Listener;

public interface RegisterDataSource {
    void register(String email, String password, Listener<String> listener);
}
