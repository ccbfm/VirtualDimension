package com.ccbfm.virtual.dimension.ui.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ccbfm.virtual.dimension.utils.LogUtils;

public abstract class BaseScene extends AppCompatActivity {
    private static final String TAG = "BaseScene";
    protected int mWidthPixels, mHeightPixels;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.w(TAG, "onCreate--=" + this);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        this.mWidthPixels = getResources().getDisplayMetrics().widthPixels;
        this.mHeightPixels = getResources().getDisplayMetrics().heightPixels;
        initData();
        setContentView(initScene(this));
    }

    protected abstract void initData();

    protected abstract View initScene(Context context);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.w(TAG, "onDestroy--=" + this);
    }
}
