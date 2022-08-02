package com.ccbfm.virtual.dimension.model;

public final class ModelConfig {

    public interface UI {
        String ACTION_DESCRIPTION = "model_ui_action_description";
        String BODY_DESCRIPTION = "model_ui_body_description";
        String DIRECTION = "model_ui_direction";
        String ENVIRONMENT = "model_ui_environment";
        String FIXED_BODY = "model_ui_fixed_body";
        String MOVING_BODY = "model_ui_moving_body";
        String OPERATION = "model_ui_operation";
    }

    public interface Cell {
        //列
        int COLUMN = 3;
        //行
        int ROW = 3;
    }
}
