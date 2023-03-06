package com.ccbfm.virtual.dimension.model;

import java.util.List;

public class VDSystem extends Model {
    private List<String> universeKeys;
    private String currentKey;

    public List<String> getUniverseKeys() {
        return universeKeys;
    }

    public void setUniverseKeys(List<String> universeKeys) {
        this.universeKeys = universeKeys;
    }

    public String getCurrentKey() {
        return currentKey;
    }

    public void setCurrentKey(String currentKey) {
        this.currentKey = currentKey;
    }
}
