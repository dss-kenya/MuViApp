package com.android.dhara.muviapp.register.router;

public interface RegisterRouter {
    void close();

    void navigateToHome();

    void navigateToLogin();

    void onBackPressed();
}
