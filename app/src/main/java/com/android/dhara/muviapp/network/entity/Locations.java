package com.android.dhara.muviapp.network.entity;

import com.google.gson.annotations.SerializedName;

public class Locations {
    private long id;
    @SerializedName("name")
    private String locationName;
    @SerializedName("loc_order")
    private int locOrder;

    public long getId() {
        return id;
    }

    public String getLocationName() {
        return locationName;
    }

    public int getLocOrder() {
        return locOrder;
    }
}
