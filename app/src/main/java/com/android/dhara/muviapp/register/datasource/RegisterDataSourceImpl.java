package com.android.dhara.muviapp.register.datasource;

import com.android.dhara.muviapp.MuViApp;
import com.android.dhara.muviapp.network.Listener;
import com.android.dhara.muviapp.network.ServiceError;
import com.android.dhara.muviapp.network.api.RestApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterDataSourceImpl implements RegisterDataSource {
    @Inject
    RestApi restApi;

    public RegisterDataSourceImpl() {
        MuViApp.getInstance().getNetComponent().inject(this);
    }

    @Override
    public void register(final String email, final String password,
                         final String firstName, final String lastName, final Listener<String> listener) {
        final Call<ResponseBody> callable = restApi.register(email,
                password, firstName, lastName);

        callable.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(final Call<ResponseBody> call, final Response<ResponseBody> response) {
                try {
                    if (response.isSuccessful()) {
                        listener.onSuccess(response.body().string());
                    } else {
                        try {
                            final String errorString = response.errorBody().string();
                            final JSONObject jsonObject = new JSONObject(errorString);
                            listener.onError(new ServiceError(jsonObject.optString("detail")));
                        } catch (final IOException e) {
                            e.printStackTrace();
                        } catch (final JSONException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(final Call<ResponseBody> call, final Throwable t) {
                listener.onError(new ServiceError(t.getMessage()));
            }
        });
    }
}
