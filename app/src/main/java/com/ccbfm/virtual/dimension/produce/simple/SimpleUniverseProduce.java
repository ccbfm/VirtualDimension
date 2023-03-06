package com.ccbfm.virtual.dimension.produce.simple;

import com.ccbfm.virtual.dimension.model.ModelConfig;
import com.ccbfm.virtual.dimension.model.Space;
import com.ccbfm.virtual.dimension.model.Universe;
import com.ccbfm.virtual.dimension.produce.BaseProduce;

public class SimpleUniverseProduce extends BaseProduce<Universe> {

    @Override
    public Universe produce() {
        Universe universe = new Universe();
        universe.setCurrentSpaceName(ModelConfig.SpaceName.MAIN);

        SimpleSpaceProduce produce = new SimpleSpaceProduce();
        produce.setKey(ModelConfig.SpaceName.MAIN);
        produce.setSize(ModelConfig.Cell.ROW, ModelConfig.Cell.COLUMN);
        Space space = produce.produce();
        universe.addSpaceMap(ModelConfig.SpaceName.MAIN, space);

        return universe;
    }
}
