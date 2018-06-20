package com.android.dhara.muviapp.dagger2.injector;

import android.content.Context;

import com.android.dhara.muviapp.dagger2.components.AppComponent;

public class AppInjector {
    private AppInjector() {

    }

    public static AppComponent from(Context context) {
        final AppComponentProvider provider = (AppComponentProvider) context.getApplicationContext();
        return provider.getAppComponent(context);
    }
}
