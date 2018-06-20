package com.android.dhara.muviapp.utils;

import java.util.Collection;

public final class ListUtils {
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }
}
