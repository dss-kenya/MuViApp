package com.android.dhara.muviapp.utils;

import android.text.TextUtils;

public class StringUtils {
    public static boolean isEmpty(final CharSequence value) {
        return !TextUtils.isEmpty(value);
    }
}
