package com.android.dhara.muviapp.home.collections.model;

import com.android.dhara.muviapp.common.ResponseListener;
import com.android.dhara.muviapp.network.entity.MuViCollections;

import java.util.List;

public interface CollectionsInteractor {
    List<MuViCollections> getCollections();

    void fetchCollections(ResponseListener listener);

    void setCategoryId(long categoryId);
}
