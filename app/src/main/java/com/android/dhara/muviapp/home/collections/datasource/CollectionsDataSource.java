package com.android.dhara.muviapp.home.collections.datasource;

import com.android.dhara.muviapp.network.Listener;
import com.android.dhara.muviapp.network.entity.CollectionResponse;

public interface CollectionsDataSource {
    void fetchCollectionList(String accessToken, long categoryId, Listener<CollectionResponse> listener);
}
