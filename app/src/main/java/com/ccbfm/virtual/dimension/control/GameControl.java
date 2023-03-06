package com.ccbfm.virtual.dimension.control;

import com.ccbfm.virtual.dimension.model.Space;
import com.ccbfm.virtual.dimension.model.Universe;
import com.ccbfm.virtual.dimension.model.VDSystem;
import com.ccbfm.virtual.dimension.model.ui.Scene;
import com.ccbfm.virtual.dimension.produce.simple.SimpleUniverseProduce;
import com.ccbfm.virtual.dimension.produce.simple.SimpleVDSystemProduce;

public class GameControl {

    private static final class Singleton {
        public static final GameControl INSTANCE = new GameControl();
    }

    public static GameControl instance() {
        return Singleton.INSTANCE;
    }

    private VDSystem mVdSystem;
    private Universe mUniverse;
    private Space mSpace;

    public void load() {
        SimpleVDSystemProduce vdSystemProduce = new SimpleVDSystemProduce();
        vdSystemProduce.setKey("");
        mVdSystem = vdSystemProduce.produce();

        SimpleUniverseProduce universeProduce = new SimpleUniverseProduce();
        universeProduce.setKey("");
        mUniverse = universeProduce.produce();
        mSpace = mUniverse.getCurrentSpace();

        changeScene(mSpace.getCurrentX(), mSpace.getCurrentY());
    }

    public void changeScene(int x, int y) {
        mSpace.setCurrentX(x);
        mSpace.setCurrentY(y);
        Scene scene = mSpace.getCurrentScene();


    }
}
