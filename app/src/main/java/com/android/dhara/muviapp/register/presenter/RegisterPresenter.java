package com.android.dhara.muviapp.register.presenter;

import com.android.dhara.muviapp.register.router.RegisterRouter;
import com.android.dhara.muviapp.register.view.RegisterView;

public interface RegisterPresenter {
    void handleOnCreate(RegisterView view, RegisterRouter router);

    void handleOnBackPressed();
}
