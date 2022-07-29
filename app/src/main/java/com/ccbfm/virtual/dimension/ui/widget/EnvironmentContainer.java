package com.ccbfm.virtual.dimension.ui.widget;

import android.content.Context;

import androidx.annotation.NonNull;

import com.ccbfm.virtual.dimension.model.ui.Environment;
import com.ccbfm.virtual.dimension.model.ModelConfig;
import com.ccbfm.virtual.dimension.ui.widget.base.Container;

public class EnvironmentContainer extends Container<Environment> {

    public EnvironmentContainer(@NonNull Context context) {
        super(context);
    }

    public EnvironmentContainer(@NonNull Context context, int widthPixels, int heightPixels) {
        super(context, widthPixels, heightPixels);
    }

    @Override
    protected void liveDataResult(Environment data) {
        super.liveDataResult(data);
    }

    @Override
    protected String liveDataKey() {
        return ModelConfig.UI.ENVIRONMENT;
    }
}
