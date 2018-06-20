package com.android.dhara.muviapp.home.collections.model;

import com.android.dhara.muviapp.MuViApp;
import com.android.dhara.muviapp.common.ResponseListener;
import com.android.dhara.muviapp.home.collections.datasource.CollectionsDataSource;
import com.android.dhara.muviapp.network.Listener;
import com.android.dhara.muviapp.network.ServiceError;
import com.android.dhara.muviapp.network.entity.CollectionResponse;
import com.android.dhara.muviapp.network.entity.MuViCollections;
import com.android.dhara.muviapp.utils.ConstantsSharedPrefs;
import com.android.dhara.muviapp.utils.SharedPrefHelper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CollectionsInteractorImpl implements CollectionsInteractor {
    private final List<MuViCollections> collections = new ArrayList<>();
    private long selectedCategoryId;

    @Inject
    CollectionsDataSource dataSource;

    public CollectionsInteractorImpl() {
        MuViApp.getInstance().getMuViAppComponent().inject(this);
    }

    @Override
    public List<MuViCollections> getCollections() {
        return collections;
    }

    @Override
    public void fetchCollections(final ResponseListener listener) {
        final String accessToken = SharedPrefHelper.getString(ConstantsSharedPrefs.ACCESS_TOKEN, "");
        dataSource.fetchCollectionList(accessToken, selectedCategoryId, new Listener<CollectionResponse>() {
            @Override
            public void onSuccess(final CollectionResponse response) {
                collections.clear();
                collections.addAll(response.getCollections());
                listener.onSuccess();
            }

            @Override
            public void onError(final ServiceError error) {
                listener.onError(error);
            }
        });
    }

    @Override
    public void setCategoryId(final long categoryId) {
        selectedCategoryId = categoryId;
    }
}
