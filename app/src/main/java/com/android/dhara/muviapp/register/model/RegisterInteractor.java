package com.android.dhara.muviapp.register.model;

import com.android.dhara.muviapp.common.ResponseListener;

public interface RegisterInteractor {
    void register(String userName, String password, ResponseListener listener);
}
