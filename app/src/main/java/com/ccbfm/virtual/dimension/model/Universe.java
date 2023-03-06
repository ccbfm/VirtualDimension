package com.ccbfm.virtual.dimension.model;

import java.util.HashMap;

public class Universe extends Model {

    private final HashMap<String, Space> spaceMap = new HashMap<>();

    private String currentSpaceName;

    public String getCurrentSpaceName() {
        return currentSpaceName;
    }

    public void setCurrentSpaceName(String currentSpaceName) {
        this.currentSpaceName = currentSpaceName;
    }

    public Space getCurrentSpace() {
        return spaceMap.get(this.currentSpaceName);
    }

    public void addSpaceMap(String name, Space space) {
        this.spaceMap.put(name, space);
    }
}
