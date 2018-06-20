package com.android.dhara.muviapp.network.entity;

import com.google.gson.annotations.SerializedName;

public class Category {
    private long id;
    @SerializedName("name")
    private String categoryName;
    @SerializedName("description")
    private String description;

    public long getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getDescription() {
        return description;
    }
}
