package com.ccbfm.virtual.dimension.ui.widget;

import android.content.Context;

import androidx.annotation.NonNull;

import com.ccbfm.virtual.dimension.model.ui.BodyDescription;
import com.ccbfm.virtual.dimension.model.ModelConfig;
import com.ccbfm.virtual.dimension.ui.widget.base.Container;

public class BodyDescriptionContainer extends Container<BodyDescription> {

    public BodyDescriptionContainer(@NonNull Context context) {
        super(context);
    }

    public BodyDescriptionContainer(@NonNull Context context, int widthPixels, int heightPixels) {
        super(context, widthPixels, heightPixels);
    }

    @Override
    protected void liveDataResult(BodyDescription data) {
        super.liveDataResult(data);
    }

    @Override
    protected String liveDataKey() {
        return ModelConfig.UI.BODY_DESCRIPTION;
    }
}
