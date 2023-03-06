package com.ccbfm.virtual.dimension.produce;

public abstract class BaseProduce<T> implements Produce<T> {

    protected String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
