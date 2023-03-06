package com.ccbfm.virtual.dimension.produce.simple;

import com.ccbfm.virtual.dimension.model.VDSystem;
import com.ccbfm.virtual.dimension.produce.BaseProduce;

import java.util.LinkedList;
import java.util.List;

public class SimpleVDSystemProduce extends BaseProduce<VDSystem> {

    @Override
    public VDSystem produce() {
        VDSystem vdSystem = new VDSystem();
        vdSystem.setCurrentKey("simple");
        List<String> keys = new LinkedList<>();
        keys.add("simple");
        vdSystem.setUniverseKeys(keys);
        return vdSystem;
    }

}
