package com.android.dhara.muviapp;

import android.content.Context;
import android.support.annotation.VisibleForTesting;
import android.support.multidex.MultiDexApplication;

import com.android.dhara.muviapp.dagger2.components.DaggerMuViAppComponent;
import com.android.dhara.muviapp.dagger2.components.MuViAppComponent;
import com.android.dhara.muviapp.dagger2.injector.AppComponentProvider;
import com.android.dhara.muviapp.dagger2.components.AppComponent;
import com.android.dhara.muviapp.dagger2.components.DaggerAppComponent;
import com.android.dhara.muviapp.dagger2.components.DaggerNetComponent;
import com.android.dhara.muviapp.dagger2.components.NetComponent;
import com.android.dhara.muviapp.dagger2.modules.AppModule;
import com.android.dhara.muviapp.dagger2.modules.MuViAppModule;
import com.android.dhara.muviapp.dagger2.modules.NetModule;
import com.android.dhara.muviapp.network.api.Api;
import com.android.dhara.muviapp.utils.ConstantsSharedPrefs;
import com.android.dhara.muviapp.utils.SharedPrefHelper;

public class MuViApp extends MultiDexApplication implements AppComponentProvider {
    private static MuViApp INSTANCE;
    private AppComponent appComponent;
    private NetComponent netComponent;
    private MuViAppComponent muViAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        MuViApp.init(this);
        getAppComponent().inject(this);
        SharedPrefHelper.putLong(ConstantsSharedPrefs.CATEGORY_ID, -1);
    }

    public static MuViApp getInstance() {
        return INSTANCE;
    }

    @VisibleForTesting
    public static void init(final Context context) {
        if (INSTANCE == null) {
            INSTANCE = (MuViApp) context;
        }
    }

    public AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(this))
                    .build();
        }
        return appComponent;
    }

    public MuViAppComponent getMuViAppComponent() {
        if (muViAppComponent == null) {
            muViAppComponent = DaggerMuViAppComponent.builder()
                    .appModule(new AppModule(this))
                    .muViAppModule(new MuViAppModule())
                    .build();
        }
        return muViAppComponent;
    }

    public NetComponent getNetComponent() {
        if (netComponent == null) {
            netComponent = DaggerNetComponent.builder()
                    .appModule(new AppModule(this))
                    .netModule(new NetModule(Api.getHost()))
                    .build();
        }
        return netComponent;
    }

    @Override
    public AppComponent getAppComponent(Context context) {
        return getAppComponent();
    }

    @Override
    public MuViAppComponent getMuViAppComponent(Context context) {
        return getMuViAppComponent();
    }

    @Override
    public NetComponent getNetComponent(Context context) {
        return getNetComponent();
    }
}
