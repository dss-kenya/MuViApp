package com.android.dhara.muviapp.dagger2.components;

import com.android.dhara.muviapp.home.category.datasource.CategoryDataSourceImpl;
import com.android.dhara.muviapp.dagger2.modules.AppModule;
import com.android.dhara.muviapp.dagger2.modules.NetModule;
import com.android.dhara.muviapp.home.collections.datasource.CollectionsDataSourceImpl;
import com.android.dhara.muviapp.home.datasource.HomeDataSourceImpl;
import com.android.dhara.muviapp.login.datasource.LoginDataSourceImpl;
import com.android.dhara.muviapp.register.datasource.RegisterDataSourceImpl;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    void inject(LoginDataSourceImpl loginDataSource);

    void inject(HomeDataSourceImpl homeDataSource);

    void inject(RegisterDataSourceImpl registerDataSource);

    void inject(CategoryDataSourceImpl categoryDataSource);

    void inject(CollectionsDataSourceImpl collectionsDataSource);
}
