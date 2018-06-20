package com.android.dhara.muviapp.network.api;

import com.android.dhara.muviapp.network.entity.CategoryResponse;
import com.android.dhara.muviapp.network.entity.CollectionResponse;
import com.android.dhara.muviapp.network.entity.LocationResponse;
import com.android.dhara.muviapp.network.entity.Locations;
import com.android.dhara.muviapp.network.entity.LoginResponse;
import com.android.dhara.muviapp.network.entity.UserResponse;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RestApi {

     /*"email": "",
    "first_name": "",
            "last_name": "",*/

    @GET("/api/v1/users/")
    Call<ResponseBody> register(@Query(value = "email") String username,
                                @Query(value = "password") String password);

    @FormUrlEncoded
    @POST("/oauth/token/")
    Call<LoginResponse> login(@Field(value = "client_id", encoded = true) String clientId,
                              @Field(value = "client_secret", encoded = true) String clientSecret,
                              @Field(value = "username", encoded = true) String userName,
                              @Field(value = "password", encoded = true) String password,
                              @Field(value="grant_type", encoded = true) String grantType);

    @GET("/api/v1/users/current-user/")
    Observable<UserResponse> getUserInfo(@Query(value = "access_token", encoded = true) String accessToken);

    @GET("/api/v1/locations/")
    Observable<LocationResponse> getLocations();

    @GET("/api/v1/categories/")
    Call<CategoryResponse> getCategories(@Query(value = "access_token", encoded = true) String accessToken);

    @GET("/api/v1/videos/")
    Observable<CollectionResponse> getCollections(@Query(value = "category_id", encoded = true) long categoryId,
                                                  @Query(value = "access_token", encoded = true) String accessToken);

    //@POST("/api/v1/categories")
    //Call<ResponseBody> getCategories(@Field(value = "access_token") String accessToken);

    /*@GET("/repos/{fullName}/subscribers")
    Observable<List<RepoOwner>> getSubscribers(@Path(value = "fullName", encoded = true) String fullName,
                                               @Query(value = "access_token", encoded = true) String accessToken);

    @GET("/users/{userName}/repos")
    Observable<List<GitHubRepo>> getOwnRepositories(@Path(value = "userName", encoded = true) String userName,
                                                    @Query(value = "access_token", encoded = true) String accessToken);*/
}