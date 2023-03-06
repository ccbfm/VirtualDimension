package com.ccbfm.virtual.dimension.model;

import com.ccbfm.virtual.dimension.model.ui.Scene;

public class Space extends Model {

    private Scene[][] scenes;

    /**
     * 行
     */
    private int row;
    /**
     * 列
     */
    private int column;

    private int currentX;
    private int currentY;

    public Scene getCurrentScene() {
        return this.scenes[currentY][currentX];
    }

    public Scene[][] getScenes() {
        return scenes;
    }

    public void setScenes(Scene[][] scenes) {
        this.scenes = scenes;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getCurrentX() {
        return currentX;
    }

    public void setCurrentX(int currentX) {
        this.currentX = currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public void setCurrentY(int currentY) {
        this.currentY = currentY;
    }
}
