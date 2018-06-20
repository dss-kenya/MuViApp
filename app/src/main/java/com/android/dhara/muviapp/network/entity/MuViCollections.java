package com.android.dhara.muviapp.network.entity;

import com.google.gson.annotations.SerializedName;

public class MuViCollections {
    private long id;
    private String name;
    @SerializedName("file_path")
    private String filePath;
    @SerializedName("description")
    private String description;
    @SerializedName("no_times_watched")
    private int numberOfTimesWatched;

    public String getName() {
        return name == null ? "" : name;
    }

    public String getDescription() {
        return description == null ? "" : description;
    }

    public String getVideoPath() {
        return filePath == null ? "" : filePath;
    }

    public int getNumberOfTimesWatched() {
        return numberOfTimesWatched;
    }
}
