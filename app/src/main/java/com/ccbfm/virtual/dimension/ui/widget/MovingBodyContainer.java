package com.ccbfm.virtual.dimension.ui.widget;

import android.content.Context;

import androidx.annotation.NonNull;

import com.ccbfm.virtual.dimension.model.ModelConfig;
import com.ccbfm.virtual.dimension.model.ui.MovingBody;
import com.ccbfm.virtual.dimension.ui.widget.base.Container;

public class MovingBodyContainer extends Container<MovingBody> {

    public MovingBodyContainer(@NonNull Context context) {
        super(context);
    }

    public MovingBodyContainer(@NonNull Context context, int widthPixels, int heightPixels) {
        super(context, widthPixels, heightPixels);
    }

    @Override
    protected void initContainer(Context context) {
        super.initContainer(context);
        setBorder();
    }

    @Override
    protected void liveDataResult(MovingBody data) {
        super.liveDataResult(data);
    }

    @Override
    protected String liveDataKey() {
        return ModelConfig.UI.MOVING_BODY;
    }
}
