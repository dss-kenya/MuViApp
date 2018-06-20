package com.android.dhara.muviapp.home.category.model;

import com.android.dhara.muviapp.MuViApp;
import com.android.dhara.muviapp.home.category.datasource.CategoryDataSource;
import com.android.dhara.muviapp.common.ResponseListener;
import com.android.dhara.muviapp.network.Listener;
import com.android.dhara.muviapp.network.ServiceError;
import com.android.dhara.muviapp.network.entity.Category;
import com.android.dhara.muviapp.network.entity.CategoryResponse;
import com.android.dhara.muviapp.utils.ConstantsSharedPrefs;
import com.android.dhara.muviapp.utils.ListUtils;
import com.android.dhara.muviapp.utils.SharedPrefHelper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CategoryInteractorImpl implements CategoryInteractor {
    @Inject
    CategoryDataSource dataSource;

    private long selectedId;

    private final List<Category> categoryList = new ArrayList<>();
    public CategoryInteractorImpl() {
        MuViApp.getInstance().getMuViAppComponent().inject(this);
    }

    @Override
    public void fetchCategories(final ResponseListener listener) {
        dataSource.fetchCategories(SharedPrefHelper.getString(ConstantsSharedPrefs.ACCESS_TOKEN, ""),
                new Listener<CategoryResponse>() {
                    @Override
                    public void onSuccess(final CategoryResponse response) {
                        categoryList.clear();
                        categoryList.addAll(response.getCategoryList());
                        listener.onSuccess();
                    }

                    @Override
                    public void onError(final ServiceError error) {
                        // FIXME: This should be handled using error codes
                        if (error.getErrorMessage().contains("Authentication")) {
                            SharedPrefHelper.remove(ConstantsSharedPrefs.ACCESS_TOKEN);
                        }
                        listener.onError(error);
                    }
                });
    }

    @Override
    public List<Category> getCategoryList() {
        return categoryList;
    }

    @Override
    public void setSelectedId(final int position) {
        if (!ListUtils.isEmpty(categoryList)) {
            selectedId = categoryList.get(position).getId();
        }

        SharedPrefHelper.putLong(ConstantsSharedPrefs.CATEGORY_ID, selectedId);
    }

    @Override
    public long getSavedSelectedId() {
        return SharedPrefHelper.getLong(ConstantsSharedPrefs.CATEGORY_ID, -1);
    }
}
