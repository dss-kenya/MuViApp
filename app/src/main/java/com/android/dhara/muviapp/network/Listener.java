package com.android.dhara.muviapp.network;

public interface Listener<T> {
    void onSuccess(T response);

    void onError(ServiceError error);
}
