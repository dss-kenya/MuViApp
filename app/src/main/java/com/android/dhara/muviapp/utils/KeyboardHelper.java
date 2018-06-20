package com.android.dhara.muviapp.utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.android.dhara.muviapp.MuViApp;

public class KeyboardHelper {
    public static void hideKeyboard(final View view) {
        if (view != null) {
            final InputMethodManager imm =
                    (InputMethodManager) MuViApp.getInstance().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
