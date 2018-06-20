package com.android.dhara.muviapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.android.dhara.muviapp.dagger2.components.ActivityComponent;
import com.android.dhara.muviapp.dagger2.components.DaggerActivityComponent;
import com.android.dhara.muviapp.dagger2.modules.ActivityModule;

import org.greenrobot.eventbus.EventBus;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .muViAppComponent(((MuViApp)getApplication()).getMuViAppComponent())
                .appComponent(((MuViApp) getApplication()).getAppComponent())
                .activityModule(new ActivityModule(this))
                .build();
    }
}