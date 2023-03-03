package com.ccbfm.virtual.dimension.ui.widget.draw;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public abstract class BaseDraw implements IDraw {
    protected final Drawable mDrawable;

    public BaseDraw(Drawable drawable) {
        this.mDrawable = drawable;
    }

    protected Rect getBounds(){
        return this.mDrawable.getBounds();
    }
}
