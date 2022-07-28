package com.ccbfm.virtual.dimension.ui.widget;

import android.content.Context;

import androidx.annotation.NonNull;

import com.ccbfm.virtual.dimension.ui.widget.base.Container;

public class FixedBodyContainer extends Container {

    public FixedBodyContainer(@NonNull Context context) {
        super(context);
    }

    public FixedBodyContainer(@NonNull Context context, int widthPixels, int heightPixels) {
        super(context, widthPixels, heightPixels);
    }
}
