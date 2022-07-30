package com.ccbfm.virtual.dimension.model.ui;

import com.ccbfm.virtual.dimension.model.OperateModel;

public class Operation extends OperateModel {

    public Operation() {

    }

    public Operation(OperateModel operateModel) {
        setOperates(operateModel.getOperates());
    }
}
