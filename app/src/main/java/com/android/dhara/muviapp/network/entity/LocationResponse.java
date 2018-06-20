package com.android.dhara.muviapp.network.entity;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.Collections;
import java.util.List;

public class LocationResponse {
    @SerializedName("results")
    private List<Locations> locationsList;

    @NonNull
    public List<Locations> getLocationsList() {
        return locationsList == null ? Collections.emptyList() : locationsList;
    }
}
