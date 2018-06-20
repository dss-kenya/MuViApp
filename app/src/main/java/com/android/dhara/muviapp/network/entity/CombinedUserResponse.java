package com.android.dhara.muviapp.network.entity;

public class CombinedUserResponse {
    private UserResponse userResponse;
    private Locations location;

    public CombinedUserResponse(final UserResponse userResponse, final Locations location) {
        this.userResponse = userResponse;
        this.location = location;
    }

    public UserResponse getUserResponse() {
        return userResponse;
    }

    public Locations getLocation() {
        return location;
    }
}
