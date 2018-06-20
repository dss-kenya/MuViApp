package com.android.dhara.muviapp.register.view;

import android.view.MenuItem;

import com.android.dhara.muviapp.common.ViewInteractionListener;

public interface RegisterView {
    void initViews(ViewInteractionListener listener);

    void showMessage(String message);

    void showProgress();

    void hideProgress();

    boolean onOptionsItemSelected(MenuItem item);

    String getEmail();

    String getPassword();

    String getFirstName();

    String getLastName();
}
