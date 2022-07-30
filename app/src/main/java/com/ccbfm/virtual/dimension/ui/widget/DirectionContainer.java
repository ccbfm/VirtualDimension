package com.ccbfm.virtual.dimension.ui.widget;

import android.content.Context;

import androidx.annotation.NonNull;

import com.ccbfm.virtual.dimension.model.ui.Direction;
import com.ccbfm.virtual.dimension.model.ModelConfig;
import com.ccbfm.virtual.dimension.ui.widget.base.Container;

public class DirectionContainer extends Container<Direction> {

    public DirectionContainer(@NonNull Context context) {
        super(context);
    }

    public DirectionContainer(@NonNull Context context, int widthPixels, int heightPixels) {
        super(context, widthPixels, heightPixels);
    }

    @Override
    protected void initContainer(Context context) {
        super.initContainer(context);
        setBorder();
    }

    @Override
    protected void liveDataResult(Direction data) {
        super.liveDataResult(data);
    }

    @Override
    protected String liveDataKey() {
        return ModelConfig.UI.DIRECTION;
    }
}
