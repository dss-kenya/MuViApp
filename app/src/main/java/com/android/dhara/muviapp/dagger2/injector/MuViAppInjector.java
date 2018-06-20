package com.android.dhara.muviapp.dagger2.injector;

import android.content.Context;

import com.android.dhara.muviapp.dagger2.components.MuViAppComponent;

public class MuViAppInjector {
    private MuViAppInjector() {

    }

    public static MuViAppComponent from(Context context) {
        final AppComponentProvider provider = (AppComponentProvider) context.getApplicationContext();
        return provider.getMuViAppComponent(context);
    }
}
