package com.android.dhara.muviapp.register.router;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;

import com.android.dhara.muviapp.home.view.HomeActivity;
import com.android.dhara.muviapp.login.view.LoginActivity;

import javax.inject.Inject;

public class RegisterRouterImpl implements RegisterRouter {
    private AppCompatActivity activity;

    @Inject
    public RegisterRouterImpl(final AppCompatActivity activity) {
        this.activity = activity;
    }

    @Override
    public void close() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.finishAfterTransition();
            return;
        }
        activity.finish();
    }

    @Override
    public void navigateToHome() {
        HomeActivity.startActivity(activity);
        close();
    }

    @Override
    public void navigateToLogin() {
        LoginActivity.startActivity(activity);
        close();
    }

    @Override
    public void onBackPressed() {
        close();
    }
}
