package com.android.dhara.muviapp.network.entity;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("access_token")
    String accessToken;
    @SerializedName("token_type")
    String tokenType;
    @SerializedName("expires_in")
    long expiresIn;
    @SerializedName("refresh_token")
    String refreshToken;
    String scope;

    public String getAccessToken() {
        return accessToken;
    }
}
