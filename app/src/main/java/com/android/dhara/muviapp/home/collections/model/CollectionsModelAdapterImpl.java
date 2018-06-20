package com.android.dhara.muviapp.home.collections.model;

import android.support.annotation.NonNull;

import com.android.dhara.muviapp.network.entity.MuViCollections;
import com.android.dhara.muviapp.utils.ListUtils;

import java.util.List;

public class CollectionsModelAdapterImpl implements CollectionsModelAdapter {
    final List<MuViCollections> collectionList;

    public static CollectionsModelAdapterImpl createFrom(final List<MuViCollections> collectionList) {
        return new CollectionsModelAdapterImpl(collectionList);
    }

    private CollectionsModelAdapterImpl(final List<MuViCollections> collectionList) {
        this.collectionList = collectionList;
    }

    @NonNull
    @Override
    public String getMuViName(final int position) {
        return ListUtils.isEmpty(collectionList) ? "" : collectionList.get(position).getName();
    }

    @NonNull
    @Override
    public String getMuViDesc(final int position) {
        return ListUtils.isEmpty(collectionList) ? "" : collectionList.get(position).getDescription();
    }

    @NonNull
    @Override
    public String getVideoPath(final int position) {
        return ListUtils.isEmpty(collectionList) ? "" : collectionList.get(position).getVideoPath();
    }

    @Override
    public int getNumberOfViews(final int position) {
        return ListUtils.isEmpty(collectionList) ? 0 : collectionList.get(position).getNumberOfTimesWatched();
    }

    @Override
    public int getCount() {
        return ListUtils.isEmpty(collectionList) ? 0 : collectionList.size();
    }
}
