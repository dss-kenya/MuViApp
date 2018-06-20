package com.android.dhara.muviapp.home.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.android.dhara.muviapp.BaseActivity;
import com.android.dhara.muviapp.R;
import com.android.dhara.muviapp.home.event.ToggleUpdateEvent;
import com.android.dhara.muviapp.home.presenter.HomePresenter;
import com.android.dhara.muviapp.home.router.HomeRouter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;

public class HomeActivity extends BaseActivity {
    @Inject
    HomePresenter presenter;

    @Inject
    HomeRouter router;

    @Inject
    HomeView homeView;

    public static void startActivity(final Context context) {
        final Intent intent = new Intent(context, HomeActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        setContentView(R.layout.activity_home);
        presenter.handleOnCreate(homeView, router);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onBackPressed() {
        presenter.handleOnBackPress();
    }

    @Subscribe
    public void onDrawerToggleUpdateEvent(ToggleUpdateEvent event) {
        homeView.handleOnDrawerToggleUpdate(event.isDrawerToggleIndicatorEnabled());
    }
}
