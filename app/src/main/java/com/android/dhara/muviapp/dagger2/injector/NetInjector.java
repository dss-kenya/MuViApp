package com.android.dhara.muviapp.dagger2.injector;

import android.content.Context;

import com.android.dhara.muviapp.dagger2.components.NetComponent;

public class NetInjector {
    private NetInjector() {

    }

    public static NetComponent from(Context context) {
        final AppComponentProvider provider = (AppComponentProvider) context.getApplicationContext();
        return provider.getNetComponent(context);
    }
}
