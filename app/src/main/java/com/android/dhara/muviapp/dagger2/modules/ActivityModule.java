package com.android.dhara.muviapp.dagger2.modules;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.android.dhara.muviapp.dagger2.injection.PerActivity;
import com.android.dhara.muviapp.dagger2.scope.ActivityScope;
import com.android.dhara.muviapp.home.presenter.HomePresenter;
import com.android.dhara.muviapp.home.presenter.HomePresenterImpl;
import com.android.dhara.muviapp.home.router.HomeRouter;
import com.android.dhara.muviapp.home.router.HomeRouterImpl;
import com.android.dhara.muviapp.home.view.HomeView;
import com.android.dhara.muviapp.home.view.HomeViewImpl;
import com.android.dhara.muviapp.login.presenter.LoginPresenter;
import com.android.dhara.muviapp.login.presenter.LoginPresenterImpl;
import com.android.dhara.muviapp.login.router.LoginRouter;
import com.android.dhara.muviapp.login.router.LoginRouterImpl;
import com.android.dhara.muviapp.login.view.LoginView;
import com.android.dhara.muviapp.login.view.LoginViewImpl;
import com.android.dhara.muviapp.register.presenter.RegisterPresenter;
import com.android.dhara.muviapp.register.presenter.RegisterPresenterImpl;
import com.android.dhara.muviapp.register.router.RegisterRouter;
import com.android.dhara.muviapp.register.router.RegisterRouterImpl;
import com.android.dhara.muviapp.register.view.RegisterView;
import com.android.dhara.muviapp.register.view.RegisterViewImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private AppCompatActivity activity;

    public ActivityModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return activity;
    }

    @Provides
    @ActivityScope
    Context providesContext() {
        return activity;
    }

    @Provides
    @PerActivity
    public HomePresenter provideHomePresenter() {
        return new HomePresenterImpl();
    }

    @Provides
    @PerActivity
    public LoginPresenter provideLoginPresenter() {
        return new LoginPresenterImpl();
    }

    @Provides
    @PerActivity
    public RegisterPresenter provideRegisterPresenter() {
        return new RegisterPresenterImpl();
    }

    @Provides
    @PerActivity
    public HomeView provideHomeView() {
        return new HomeViewImpl(activity);
    }

    @Provides
    @PerActivity
    public LoginView provideLoginView() {
        return new LoginViewImpl(activity);
    }

    @Provides
    @PerActivity
    public LoginRouter provideLoginRouter() {
        return new LoginRouterImpl(activity);
    }

    @Provides
    @PerActivity
    public HomeRouter provideHomeRouter() {
        return new HomeRouterImpl(activity);
    }

    @Provides
    @PerActivity
    public RegisterView provideRegisterView() {
        return new RegisterViewImpl(activity);
    }

    @Provides
    @PerActivity
    public RegisterRouter provideRegisterRouter() {
        return new RegisterRouterImpl(activity);
    }
}