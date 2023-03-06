package com.ccbfm.virtual.dimension.ui.widget.base;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ScrollView;

import com.ccbfm.virtual.dimension.ui.ColorConfig;
import com.ccbfm.virtual.dimension.ui.PxConfig;

public class Scroll extends ScrollView {
    protected int mPadding;

    public Scroll(Context context) {
        super(context);
        //去除竖直滚动条
        setVerticalScrollBarEnabled(false);
        //去除边界特效
        setOverScrollMode(OVER_SCROLL_NEVER);
    }

    public Scroll border() {
        return border(PxConfig.PxInt.SCROLL_BORDER, ColorConfig.CInt.C000000);
    }

    public Scroll border(int border, int borderColor) {
        setPadding(border);
        setBackground(MixDrawable.build().setBorder(border, borderColor));
        return this;
    }

    protected void setPadding(int padding) {
        if (this.mPadding < padding) {
            this.mPadding = padding;
        }
    }

    public Scroll padding(){
        return padding(this.mPadding);
    }

    public Scroll padding(int padding){
        if (this.mPadding < padding) {
            this.mPadding = padding;
        }
        int n_p = this.mPadding + PxConfig.PxInt.TEXT_PADDING;
        setPadding(n_p, n_p, n_p, n_p);
        return this;
    }

    public static class LayoutParams extends FrameLayout.LayoutParams {
        public LayoutParams(int width, int height) {
            super(width, height);
        }

        public LayoutParams(int width, int height, int gravity) {
            super(width, height, gravity);
        }
    }
}
