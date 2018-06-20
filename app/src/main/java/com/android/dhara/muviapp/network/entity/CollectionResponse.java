package com.android.dhara.muviapp.network.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CollectionResponse {
    @SerializedName("results")
    private List<MuViCollections> collections;

    public List<MuViCollections> getCollections() {
        return collections;
    }
}
