package com.android.dhara.muviapp.dagger2.modules;

import android.app.Application;

import com.android.dhara.muviapp.network.api.RestApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

@Singleton
@Module
public class NetModule {
    final String baseUrl;

    public NetModule(final String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Provides
    @Singleton
    public Cache provideHttpCache(final Application application) {
        final int cacheSize = 10 * 1024 * 1024;
        new Cache(application.getCacheDir(), cacheSize);
        return new Cache(application.getCacheDir(), cacheSize);
    }

    @Provides
    @Singleton
    public Gson provideGson() {
        GsonBuilder builder = new GsonBuilder();
        builder.setLenient();
        return builder.create();
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkhttpClient(final Cache cache) {
        final HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        final OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.cache(cache);
        client.addInterceptor(logging);
        return client.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(final Gson gson, final OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .build();
    }

    @Provides
    @Singleton
    public RestApi getApiService(Retrofit retrofit) {
        return retrofit.create(RestApi.class);
    }
}