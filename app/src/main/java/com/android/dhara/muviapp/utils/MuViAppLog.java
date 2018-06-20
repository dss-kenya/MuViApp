package com.android.dhara.muviapp.utils;

import android.util.Log;

import com.android.dhara.muviapp.BuildConfig;
import com.android.dhara.muviapp.MuViApp;
import com.android.dhara.muviapp.dagger2.injector.AppInjector;

public class MuViAppLog {
    public MuViAppLog() {
        AppInjector.from(MuViApp.getInstance()).inject(this);
    }

    public void v(final String tag, final String msg) {
        if (useLog()) {
            Log.v(String.valueOf(tag), String.valueOf(msg));
        }
    }

    public void d(final String tag, final String msg) {
        if (useLog()) {
            Log.d(String.valueOf(tag), String.valueOf(msg));
        }
    }

    public void e(final String tag, final String msg) {
        if (useLog()) {
            Log.e(String.valueOf(tag), String.valueOf(msg));
        }
    }

    public void wtf(final String tag, final Throwable throwable) {
        if (useLog()) {
            Log.wtf(String.valueOf(tag), throwable);
        }
    }

    private static boolean useLog() {
        return BuildConfig.DEBUG;
    }
}