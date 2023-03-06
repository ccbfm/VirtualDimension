package com.ccbfm.virtual.dimension.produce;

public abstract class SpaceProduce<T> extends BaseProduce<T> {

    protected int row, column;

    public void setSize(int row, int column) {
        this.row = row;
        this.column = column;
    }
}
