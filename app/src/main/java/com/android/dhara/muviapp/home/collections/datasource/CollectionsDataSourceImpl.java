package com.android.dhara.muviapp.home.collections.datasource;

import com.android.dhara.muviapp.MuViApp;
import com.android.dhara.muviapp.dagger2.injector.NetInjector;
import com.android.dhara.muviapp.network.Listener;
import com.android.dhara.muviapp.network.ServiceError;
import com.android.dhara.muviapp.network.api.RestApi;
import com.android.dhara.muviapp.network.entity.CollectionResponse;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CollectionsDataSourceImpl implements CollectionsDataSource {
    @Inject
    RestApi restApi;

    public CollectionsDataSourceImpl() {
        NetInjector.from(MuViApp.getInstance()).inject(this);
    }

    @Override
    public void fetchCollectionList(final String accessToken,
                                    final long categoryId,
                                    final Listener<CollectionResponse> listener) {
        restApi.getCollections(categoryId, accessToken)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .doOnError(error -> listener.onError(new ServiceError(error.getMessage())))
                .onErrorReturn(throwable -> null)
                .subscribe(listener::onSuccess);
    }
}
