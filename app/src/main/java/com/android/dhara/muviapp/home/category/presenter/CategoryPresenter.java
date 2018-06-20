package com.android.dhara.muviapp.home.category.presenter;

import com.android.dhara.muviapp.home.category.router.CategoryRouter;
import com.android.dhara.muviapp.home.category.view.CategoryView;

public interface CategoryPresenter {
    void handleOnViewCreated(CategoryView view, CategoryRouter router);

    void handleOnResume();
}
