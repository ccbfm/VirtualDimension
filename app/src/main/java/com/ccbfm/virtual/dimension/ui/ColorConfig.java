package com.ccbfm.virtual.dimension.ui;

import android.graphics.Color;

import androidx.annotation.ColorInt;

public final class ColorConfig {

    public interface CInt {
        @ColorInt
        int C000000 = Color.parseColor("#000000");
        @ColorInt
        int CFFFFFF = Color.parseColor("#FFFFFF");
    }
}
