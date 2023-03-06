package com.ccbfm.virtual.dimension.ui.widget.base;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;

import com.ccbfm.virtual.dimension.utils.LogUtils;
import com.ccbfm.virtual.dimension.utils.livedata.LiveDataBus;

public class Container<T> extends FrameLayout implements LifecycleObserver, View.OnClickListener {
    private static final String TAG = "Container";
    private static final boolean DEBUG = true;
    protected final Handler mMainHandler;
    protected int mWidthPixels, mHeightPixels;
    protected int mPaddingLeft, mPaddingTop, mPaddingRight, mPaddingBottom;
    protected Lifecycle mLifecycle;

    public Container(@NonNull Context context) {
        this(context, 0, 0);
    }

    public Container(@NonNull Context context, int widthPixels, int heightPixels) {
        super(context);
        setBackground();
        this.mWidthPixels = widthPixels - mPaddingLeft - mPaddingRight;
        this.mHeightPixels = heightPixels - mPaddingTop - mPaddingBottom;
        this.mMainHandler = new Handler(Looper.getMainLooper());

        setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
        initContainer(context);

        if (context instanceof LifecycleOwner) {
            initLifecycleOwner((LifecycleOwner) context);
        }
    }

    protected void initLifecycleOwner(LifecycleOwner lifecycleOwner) {
        String liveDataKey = liveDataKey();
        LogUtils.d(TAG, "initLifecycleOwner--liveDataKey=" + liveDataKey
                + ",lifecycleOwner=" + lifecycleOwner, false);
        if (!TextUtils.isEmpty(liveDataKey) && lifecycleOwner != null) {
            LiveDataBus.get().<T>with(liveDataKey)
                    .observe(lifecycleOwner, new Observer<T>() {
                        @Override
                        public void onChanged(T data) {
                            liveDataResult(data);
                        }
                    });
        }
    }

    protected void initContainer(Context context) {
        LogUtils.d(TAG, "initContainer--=" + getSimpleName(), DEBUG);

    }

    protected void setBackground() {

    }

    public void setLifecycle(Lifecycle lifecycle) {
        if (lifecycle != null) {
            lifecycle.addObserver(this);
        }
        this.mLifecycle = lifecycle;
    }

    protected void liveDataResult(T data) {
        LogUtils.d(TAG, "liveDataResult--=" + data + "--" + getSimpleName(), DEBUG);
    }

    @Override
    public void onClick(View v) {
        LogUtils.d(TAG, "onClick--=" + v + "--" + getSimpleName(), DEBUG);
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

    protected String liveDataKey() {
        return null;
    }

    protected String getSimpleName() {
        return this.getClass().getSimpleName();
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
