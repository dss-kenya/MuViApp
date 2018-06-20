package com.android.dhara.muviapp.login.datasource;

import com.android.dhara.muviapp.MuViApp;
import com.android.dhara.muviapp.network.Listener;
import com.android.dhara.muviapp.network.ServiceError;
import com.android.dhara.muviapp.network.api.RestApi;
import com.android.dhara.muviapp.network.entity.LoginResponse;
import com.android.dhara.muviapp.utils.AppConstants;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginDataSourceImpl implements LoginDataSource {
    @Inject
    RestApi restApi;

    public LoginDataSourceImpl() {
        MuViApp.getInstance().getNetComponent().inject(this);
    }

    @Override
    public void login(final String userName, final String password, final Listener<LoginResponse> listener) {
        final Call<LoginResponse> callable = restApi.login(AppConstants.CLIENT_ID,
                AppConstants.CLIENT_SECRET,
                userName,
                password,
                AppConstants.GRANT_TYPE);

        callable.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(final Call<LoginResponse> call, final Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body());
                } else {
                    try {
                        final String errorString = response.errorBody().string();
                        final JSONObject jObj = new JSONObject(errorString);
                        listener.onError(new ServiceError(jObj.optString("error_description")));
                    } catch (final IOException e) {
                        e.printStackTrace();
                    } catch (final JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(final Call<LoginResponse> call, final Throwable t) {
                listener.onError(new ServiceError(t.getMessage()));
            }
        });
    }
}
