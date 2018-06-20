package com.android.dhara.muviapp.register.model;

import com.android.dhara.muviapp.MuViApp;
import com.android.dhara.muviapp.common.ResponseListener;
import com.android.dhara.muviapp.dagger2.injector.MuViAppInjector;
import com.android.dhara.muviapp.network.Listener;
import com.android.dhara.muviapp.network.ServiceError;
import com.android.dhara.muviapp.register.datasource.RegisterDataSource;
import com.android.dhara.muviapp.utils.MuViAppLog;

import javax.inject.Inject;

public class RegisterInteractorImpl implements RegisterInteractor {
    @Inject
    RegisterDataSource dataSource;

    @Inject
    MuViAppLog logger;

    public RegisterInteractorImpl() {
        MuViAppInjector.from(MuViApp.getInstance()).inject(this);
    }

    @Override
    public void register(final String email, final String password,
                         final String firstName, final String lastName, final ResponseListener listener) {
        dataSource.register(email, password, firstName, lastName, new Listener<String>() {
            @Override
            public void onSuccess(final String response) {
                listener.onSuccess();
            }

            @Override
            public void onError(final ServiceError error) {
                listener.onError(error);
            }
        });
    }
}
