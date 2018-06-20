package com.android.dhara.muviapp.common;

import com.android.dhara.muviapp.network.ServiceError;

public interface ResponseListener {
    void onSuccess();

    void onError(ServiceError error);
}