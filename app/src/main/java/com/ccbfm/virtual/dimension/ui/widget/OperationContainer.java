package com.ccbfm.virtual.dimension.ui.widget;

import android.content.Context;

import androidx.annotation.NonNull;

import com.ccbfm.virtual.dimension.model.ModelConfig;
import com.ccbfm.virtual.dimension.model.ui.Operation;
import com.ccbfm.virtual.dimension.ui.widget.base.Container;

public class OperationContainer extends Container<Operation> {

    public OperationContainer(@NonNull Context context) {
        super(context);
    }

    public OperationContainer(@NonNull Context context, int widthPixels, int heightPixels) {
        super(context, widthPixels, heightPixels);
    }

    @Override
    protected void liveDataResult(Operation data) {
        super.liveDataResult(data);
    }

    @Override
    protected String liveDataKey() {
        return ModelConfig.UI.OPERATION;
    }
}
