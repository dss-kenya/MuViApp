package com.android.dhara.muviapp.network.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryResponse {
    @SerializedName("results")
    private List<Category> categoryList;

    public List<Category> getCategoryList() {
        return categoryList;
    }
}
