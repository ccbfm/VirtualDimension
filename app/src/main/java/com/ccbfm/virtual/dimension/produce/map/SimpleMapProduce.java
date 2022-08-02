package com.ccbfm.virtual.dimension.produce.map;

import com.ccbfm.virtual.dimension.model.ui.Scene;
import com.ccbfm.virtual.dimension.produce.MapProduce;

public class SimpleMapProduce implements MapProduce<Scene[][]> {

    @Override
    public void setSize(int row, int column) {

    }

    @Override
    public Scene[][] produce() {
        return new Scene[0][];
    }
}
