package com.android.dhara.muviapp.dagger2.components;

import com.android.dhara.muviapp.home.category.model.CategoryInteractorImpl;
import com.android.dhara.muviapp.home.category.presenter.CategoryPresenterImpl;
import com.android.dhara.muviapp.dagger2.modules.AppModule;
import com.android.dhara.muviapp.dagger2.modules.MuViAppModule;
import com.android.dhara.muviapp.home.collections.model.CollectionsInteractorImpl;
import com.android.dhara.muviapp.home.collections.presenter.CollectionsPresenterImpl;
import com.android.dhara.muviapp.home.model.HomeInteractorImpl;
import com.android.dhara.muviapp.home.presenter.HomePresenterImpl;
import com.android.dhara.muviapp.login.model.LoginInteractorImpl;
import com.android.dhara.muviapp.login.presenter.LoginPresenterImpl;
import com.android.dhara.muviapp.register.model.RegisterInteractorImpl;
import com.android.dhara.muviapp.register.presenter.RegisterPresenterImpl;

import dagger.Component;

@Component(modules = {MuViAppModule.class, AppModule.class})
public interface MuViAppComponent {
    void inject(HomePresenterImpl presenter);

    void inject(HomeInteractorImpl mainInteractor);

    void inject(LoginPresenterImpl loginPresenter);

    void inject(LoginInteractorImpl loginInteractor);

    void inject(RegisterPresenterImpl registerPresenter);

    void inject(RegisterInteractorImpl registerInteractor);

    void inject(CategoryPresenterImpl categoryPresenter);

    void inject(CategoryInteractorImpl categoryInteractor);

    void inject(CollectionsPresenterImpl collectionsPresenter);

    void inject(CollectionsInteractorImpl collectionsInteractor);
}
