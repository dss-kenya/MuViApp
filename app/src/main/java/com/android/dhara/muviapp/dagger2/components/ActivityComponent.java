package com.android.dhara.muviapp.dagger2.components;

import com.android.dhara.muviapp.dagger2.injection.PerActivity;
import com.android.dhara.muviapp.dagger2.modules.ActivityModule;
import com.android.dhara.muviapp.home.view.HomeActivity;
import com.android.dhara.muviapp.login.view.LoginActivity;
import com.android.dhara.muviapp.register.view.RegistrationActivity;

import dagger.Component;

@PerActivity
@Component(modules = {ActivityModule.class}, dependencies = {AppComponent.class, MuViAppComponent.class})
public interface ActivityComponent {
    void inject(LoginActivity activity);

    void inject(HomeActivity homeActivity);

    void inject(RegistrationActivity activity);
}
