package com.ccbfm.virtual.dimension.ui.widget.base;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class Container extends FrameLayout implements LifecycleObserver {
    private static final String TAG = "Container";
    protected int mWidthPixels, mHeightPixels;
    protected Lifecycle mLifecycle;

    public Container(@NonNull Context context) {
        this(context, 0, 0);
    }

    public Container(@NonNull Context context, int widthPixels, int heightPixels) {
        super(context);
        this.mWidthPixels = widthPixels;
        this.mHeightPixels = heightPixels;
        initContainer(context);
    }

    protected void initContainer(Context context) {

    }

    public void setLifecycle(Lifecycle lifecycle) {
        if (lifecycle != null) {
            lifecycle.addObserver(this);
        }
        this.mLifecycle = lifecycle;
    }


    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        if (this.mLifecycle != null && (child instanceof LifecycleObserver)) {
            this.mLifecycle.addObserver((LifecycleObserver) child);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    protected void onStart() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    protected void onStop() {

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
