package com.ccbfm.virtual.dimension.model.ui;

import com.ccbfm.virtual.dimension.model.ModelConfig;

public class Direction {

    protected Scene[][] scenes;

    public Scene[][] getScenes() {
        return scenes;
    }

    public void setScenes(Scene[][] scenes) {
        this.scenes = scenes;
    }

    public void setScenes(int row, int column, Scene scene) {
        if (this.scenes == null) {
            this.scenes = new Scene[ModelConfig.Cell.ROW][ModelConfig.Cell.COLUMN];
        }
        this.scenes[row][column] = scene;
    }
}
