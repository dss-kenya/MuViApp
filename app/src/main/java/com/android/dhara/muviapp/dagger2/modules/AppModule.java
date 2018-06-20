package com.android.dhara.muviapp.dagger2.modules;

import android.app.Application;

import com.android.dhara.muviapp.MuViApp;
import com.android.dhara.muviapp.utils.MuViAppLog;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Singleton
@Module
public class AppModule {
    private final MuViApp application;

    public AppModule(final MuViApp application) {
        this.application = application;
    }

    @Provides
    Application provideApplication() {
        return application;
    }

    @Provides
    public MuViAppLog provideMuViAppLog() {
        return new MuViAppLog();
    }
}
