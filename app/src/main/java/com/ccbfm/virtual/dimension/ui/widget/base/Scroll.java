package com.ccbfm.virtual.dimension.ui.widget.base;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ScrollView;

public class Scroll extends ScrollView {

    public Scroll(Context context) {
        super(context);
        //去除竖直滚动条
        setVerticalScrollBarEnabled(false);
        //去除边界特效
        setOverScrollMode(OVER_SCROLL_NEVER);
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
