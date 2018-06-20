package com.android.dhara.muviapp.network.api;

public class Api {
    private static String BASE_URL = "http://api.smartduka.busaracenterlab.org/";
    public static final String RESULT_OK = "ok";

    private Api() { }

    public static String getHost() {
        return BASE_URL;
    }
}
