package com.android.dhara.muviapp.home.category.datasource;

import com.android.dhara.muviapp.MuViApp;
import com.android.dhara.muviapp.network.Listener;
import com.android.dhara.muviapp.network.ServiceError;
import com.android.dhara.muviapp.network.api.RestApi;
import com.android.dhara.muviapp.network.entity.CategoryResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryDataSourceImpl implements CategoryDataSource {
    @Inject
    RestApi restApi;

    public CategoryDataSourceImpl() {
        MuViApp.getInstance().getNetComponent().inject(this);
    }

    @Override
    public void fetchCategories(final String accessToken, final Listener<CategoryResponse> listener) {
        restApi.getCategories(accessToken).enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(final Call<CategoryResponse> call, final Response<CategoryResponse> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body());
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
            }

            @Override
            public void onFailure(final Call<CategoryResponse> call, final Throwable t) {
                listener.onError(new ServiceError(t.getMessage()));
            }
        });
    }
}
