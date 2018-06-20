package com.android.dhara.muviapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.dhara.muviapp.MuViApp;

public class SharedPrefHelper {
    private static SharedPreferences getSharedPreferences() {
        return MuViApp.getInstance().getSharedPreferences(ConstantsSharedPrefs
                .SHARED_PREFERENCES, Context.MODE_PRIVATE);
    }

    public static boolean contains(final String sharedName) {
        return getSharedPreferences().contains(sharedName);
    }

    // ----- GET... ---- //

    public static int getInt(final String sharedName, final int defValue) {
        return getSharedPreferences().getInt(sharedName, defValue);
    }

    public static long getLong(final String sharedName, final long defValue) {
        return getSharedPreferences().getLong(sharedName, defValue);
    }


    public static boolean getBoolean(final String sharedName, final boolean defValue) {
        return getSharedPreferences().getBoolean(sharedName, defValue);
    }

    public static String getString(final String sharedName, final String defValue) {
        final SharedPreferences sharedPrefs = getSharedPreferences();
        return sharedPrefs.getString(sharedName, defValue);
    }

    // ----- PUT... ---- //

    public static void putInt(final String sharedName, final int value) {
        final SharedPreferences.Editor edit = getSharedPreferences().edit();
        edit.putInt(sharedName, value);
        edit.apply();
    }

    public static void putLong(final String sharedName, final long value) {
        final SharedPreferences.Editor edit = getSharedPreferences().edit();
        edit.putLong(sharedName, value);
        edit.apply();
    }

    public static void putBoolean(final String sharedName, final boolean value) {
        final SharedPreferences.Editor edit = getSharedPreferences().edit();
        edit.putBoolean(sharedName, value);
        edit.apply();
    }

    public static void putString(final String sharedName, final String value) {
        final SharedPreferences sharedPrefs = getSharedPreferences();
        final SharedPreferences.Editor edit = sharedPrefs.edit();
        edit.putString(sharedName, value);
        edit.apply();
    }

    public static void remove(final String key) {
        final SharedPreferences sharedPrefs = getSharedPreferences();
        final SharedPreferences.Editor edit = sharedPrefs.edit();
        edit.remove(key);
        edit.apply();
    }
}