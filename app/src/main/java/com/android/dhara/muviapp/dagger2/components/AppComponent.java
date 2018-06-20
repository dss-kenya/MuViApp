package com.android.dhara.muviapp.dagger2.components;

import android.app.Application;

import com.android.dhara.muviapp.MuViApp;
import com.android.dhara.muviapp.dagger2.modules.AppModule;
import com.android.dhara.muviapp.utils.MuViAppLog;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(MuViApp muViApp);

    void inject(MuViAppLog muViAppLog);

    Application application();

    MuViAppLog getMuViAppLog();
}
