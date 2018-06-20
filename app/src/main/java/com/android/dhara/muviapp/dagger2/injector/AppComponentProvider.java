package com.android.dhara.muviapp.dagger2.injector;

import android.content.Context;

import com.android.dhara.muviapp.dagger2.components.AppComponent;
import com.android.dhara.muviapp.dagger2.components.MuViAppComponent;
import com.android.dhara.muviapp.dagger2.components.NetComponent;

public interface AppComponentProvider {
    AppComponent getAppComponent(Context context);

    MuViAppComponent getMuViAppComponent(Context context);

    NetComponent getNetComponent(Context context);
}
