package com.ccbfm.virtual.dimension.produce.simple;

import com.ccbfm.virtual.dimension.model.Space;
import com.ccbfm.virtual.dimension.model.ui.Scene;
import com.ccbfm.virtual.dimension.produce.SpaceProduce;

public class SimpleSpaceProduce extends SpaceProduce<Space> {

    @Override
    public Space produce() {
        Space space = new Space();
        space.setRow(this.row);
        space.setColumn(this.column);

        space.setCurrentX(1);
        space.setCurrentY(1);

        Scene[][] scenes = new Scene[this.row][this.column];
        space.setScenes(scenes);

        return space;
    }

}
