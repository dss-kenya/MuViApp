package com.android.dhara.muviapp.home.datasource;

import com.android.dhara.muviapp.MuViApp;
import com.android.dhara.muviapp.dagger2.injector.NetInjector;
import com.android.dhara.muviapp.network.Listener;
import com.android.dhara.muviapp.network.ServiceError;
import com.android.dhara.muviapp.network.api.RestApi;
import com.android.dhara.muviapp.network.entity.CombinedUserResponse;
import com.android.dhara.muviapp.network.entity.LocationResponse;
import com.android.dhara.muviapp.network.entity.Locations;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class HomeDataSourceImpl implements HomeDataSource {
    @Inject
    RestApi restApiService;

    public HomeDataSourceImpl() {
        NetInjector.from(MuViApp.getInstance()).inject(this);
    }

    @Override
    public void fetchUserInfo(final String accessToken, final Listener<CombinedUserResponse> listener) {
        restApiService.getUserInfo(accessToken).subscribeOn(Schedulers.io())
                .flatMap(userResponse -> getLocationList(userResponse.getLocationId(), listener), CombinedUserResponse::new)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorReturn(throwable -> null)
                .doOnError(error -> listener.onError(new ServiceError(error.getMessage())))
                .subscribe(listener::onSuccess);
    }

    private Observable<Locations> getLocationList(final long locationId, final Listener<?> listener) {
        return restApiService.getLocations().subscribeOn(Schedulers.io())
                .flatMapIterable(LocationResponse::getLocationsList)
                .filter(locations -> locations.getId() == locationId)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(throwable -> listener.onError(new ServiceError(throwable.getMessage())))
                .onErrorReturn(throwable -> null);
    }
}
