package com.ccbfm.virtual.dimension.ui.view;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;

import com.ccbfm.virtual.dimension.ui.widget.ActionDescriptionContainer;
import com.ccbfm.virtual.dimension.ui.widget.BodyDescriptionContainer;
import com.ccbfm.virtual.dimension.ui.widget.DirectionContainer;
import com.ccbfm.virtual.dimension.ui.widget.EnvironmentContainer;
import com.ccbfm.virtual.dimension.ui.widget.FixedBodyContainer;
import com.ccbfm.virtual.dimension.ui.widget.MovingBodyContainer;
import com.ccbfm.virtual.dimension.ui.widget.OperationContainer;
import com.ccbfm.virtual.dimension.ui.widget.base.Container;

public class GameScene extends BaseScene {

    @Override
    protected void initData() {

    }

    @Override
    protected View initScene(Context context) {
        int wp = mWidthPixels;
        int hp = mHeightPixels;

        int wp_2 = mWidthPixels >> 1;
        int wp_4 = mWidthPixels >> 2;
        int hp_3 = mHeightPixels / 3;
        int hp_6 = hp_3 >> 1;

        Container container = new Container(context);
        container.setLifecycle(getLifecycle());

        EnvironmentContainer environment = new EnvironmentContainer(context, wp, hp_6);
        environment.setBackgroundColor(Color.BLUE);
        Container.LayoutParams envLp = new Container.LayoutParams(wp, hp_6);
        container.addView(environment, envLp);

        BodyDescriptionContainer bodyDescription = new BodyDescriptionContainer(context, wp, hp_6);
        bodyDescription.setBackgroundColor(Color.GREEN);
        Container.LayoutParams bodyLp = new Container.LayoutParams(wp, hp_6);
        bodyLp.topMargin = hp_6;
        container.addView(bodyDescription, bodyLp);

        int fbHp = hp - hp_3;
        FixedBodyContainer fixedBody = new FixedBodyContainer(context, wp_4, fbHp);
        fixedBody.setBackgroundColor(Color.GRAY);
        Container.LayoutParams fixedLp = new Container.LayoutParams(wp_4, fbHp);
        fixedLp.topMargin = hp_3;
        container.addView(fixedBody, fixedLp);

        MovingBodyContainer movingBody = new MovingBodyContainer(context, wp_4, hp_3);
        movingBody.setBackgroundColor(Color.YELLOW);
        Container.LayoutParams movingLp = new Container.LayoutParams(wp_4, hp_3, Gravity.END);
        movingLp.topMargin = hp_3;
        container.addView(movingBody, movingLp);

        ActionDescriptionContainer actionDescription = new ActionDescriptionContainer(context, wp_2, hp_3);
        actionDescription.setBackgroundColor(Color.BLACK);
        Container.LayoutParams actionLp = new Container.LayoutParams(wp_2, hp_3);
        actionLp.topMargin = hp_3;
        actionLp.leftMargin = wp_4;
        container.addView(actionDescription, actionLp);

        DirectionContainer direction = new DirectionContainer(context, wp_2, hp_3);
        direction.setBackgroundColor(Color.RED);
        Container.LayoutParams dirLp = new Container.LayoutParams(wp_2, hp_3, Gravity.END);
        dirLp.topMargin = hp - hp_3;
        container.addView(direction, dirLp);

        OperationContainer operation = new OperationContainer(context, wp_4, hp_3);
        operation.setBackgroundColor(Color.LTGRAY);
        Container.LayoutParams opeLp = new Container.LayoutParams(wp_4, hp_3);
        opeLp.topMargin = hp - hp_3;
        opeLp.leftMargin = wp_4;
        container.addView(operation, opeLp);

        return container;
    }
}
