package com.android.dhara.muviapp.network.entity;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class UserResponse {
    @SerializedName("email")
    private String userName;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("id")
    private long id;
    @SerializedName("phone_number")
    private String phoneNumber;
    @SerializedName("location")
    private long locationId;

    @NonNull
    public String getUserName() {
        return userName == null ? "" : userName;
    }

    public String getName() {
        final String _lastName = lastName == null ? "" : lastName;
        final String _firstName = firstName == null ? "" : firstName;
        return _firstName + ' ' + _lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public long getLocationId() {
        return locationId;
    }

    public long getId() {
        return id;
    }
}
