package com.android.dhara.muviapp.register.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.MenuItem;

import com.android.dhara.muviapp.BaseActivity;
import com.android.dhara.muviapp.R;
import com.android.dhara.muviapp.register.presenter.RegisterPresenter;
import com.android.dhara.muviapp.register.router.RegisterRouter;

import javax.inject.Inject;

public class RegistrationActivity extends BaseActivity {
    @Inject
    RegisterPresenter presenter;

    @Inject
    RegisterView registerView;

    @Inject
    RegisterRouter registerRouter;

    public static void startActivity(final Context context) {
        final Intent intent = new Intent(context, RegistrationActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        ActivityCompat.startActivity(context, intent, null);
    }

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        setContentView(R.layout.activity_register);
        presenter.handleOnCreate(registerView, registerRouter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return registerView.onOptionsItemSelected(item);
    }
}
