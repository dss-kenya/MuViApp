package com.android.dhara.muviapp.dagger2.modules;

import com.android.dhara.muviapp.home.category.datasource.CategoryDataSource;
import com.android.dhara.muviapp.home.category.datasource.CategoryDataSourceImpl;
import com.android.dhara.muviapp.home.category.model.CategoryInteractor;
import com.android.dhara.muviapp.home.category.model.CategoryInteractorImpl;
import com.android.dhara.muviapp.home.collections.datasource.CollectionsDataSource;
import com.android.dhara.muviapp.home.collections.datasource.CollectionsDataSourceImpl;
import com.android.dhara.muviapp.home.collections.model.CollectionsInteractor;
import com.android.dhara.muviapp.home.collections.model.CollectionsInteractorImpl;
import com.android.dhara.muviapp.home.datasource.HomeDataSource;
import com.android.dhara.muviapp.home.datasource.HomeDataSourceImpl;
import com.android.dhara.muviapp.home.model.HomeInteractor;
import com.android.dhara.muviapp.home.model.HomeInteractorImpl;
import com.android.dhara.muviapp.login.datasource.LoginDataSource;
import com.android.dhara.muviapp.login.datasource.LoginDataSourceImpl;
import com.android.dhara.muviapp.login.model.LoginInteractor;
import com.android.dhara.muviapp.login.model.LoginInteractorImpl;
import com.android.dhara.muviapp.register.datasource.RegisterDataSource;
import com.android.dhara.muviapp.register.datasource.RegisterDataSourceImpl;
import com.android.dhara.muviapp.register.model.RegisterInteractor;
import com.android.dhara.muviapp.register.model.RegisterInteractorImpl;
import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;

@Module
public class MuViAppModule {
    @Provides
    public Gson provideGson() {
        return new Gson();
    }

    @Provides
    public LoginInteractor provideLoginInteractor() {
        return new LoginInteractorImpl();
    }

    @Provides
    public LoginDataSource provideLoginDataSource() {
        return new LoginDataSourceImpl();
    }

    @Provides
    public HomeInteractor provideHomeInteractor() {
        return new HomeInteractorImpl();
    }

    @Provides
    public HomeDataSource provideHomeDataSource() {
        return new HomeDataSourceImpl();
    }

    @Provides
    public RegisterInteractor provideRegisterInteractor() {
        return new RegisterInteractorImpl();
    }

    @Provides
    public RegisterDataSource provideRegisterDataSource() {
        return new RegisterDataSourceImpl();
    }

    @Provides
    public CategoryInteractor provideCategoryInteractor() {
        return new CategoryInteractorImpl();
    }

    @Provides
    public CategoryDataSource provideCategoryDataSource() {
        return new CategoryDataSourceImpl();
    }

    @Provides
    public CollectionsInteractor provideCollectionsInteractor() {
        return new CollectionsInteractorImpl();
    }

    @Provides
    public CollectionsDataSource provideCollectionsDataSource() {
        return new CollectionsDataSourceImpl();
    }
}
