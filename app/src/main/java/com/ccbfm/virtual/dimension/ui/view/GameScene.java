package com.ccbfm.virtual.dimension.ui.view;

import android.content.Context;
import android.view.Gravity;
import android.view.View;

import com.ccbfm.virtual.dimension.model.ModelConfig;
import com.ccbfm.virtual.dimension.model.ui.Environment;
import com.ccbfm.virtual.dimension.ui.widget.ActionDescriptionContainer;
import com.ccbfm.virtual.dimension.ui.widget.BodyDescriptionContainer;
import com.ccbfm.virtual.dimension.ui.widget.DirectionContainer;
import com.ccbfm.virtual.dimension.ui.widget.EnvironmentContainer;
import com.ccbfm.virtual.dimension.ui.widget.FixedBodyContainer;
import com.ccbfm.virtual.dimension.ui.widget.MovingBodyContainer;
import com.ccbfm.virtual.dimension.ui.widget.OperationContainer;
import com.ccbfm.virtual.dimension.ui.widget.base.Container;
import com.ccbfm.virtual.dimension.utils.PxUtils;
import com.ccbfm.virtual.dimension.utils.livedata.LiveDataBus;

public class GameScene extends BaseScene {

    @Override
    protected void initData() {
        Environment environment = new Environment();
        environment.setName("xx");
        environment.setDescription("xxx\nxxx\nxxx\nxxx\nxxx\nxxx\nxxx\nxxx\nxxx");
        LiveDataBus.get().<Environment>with(ModelConfig.UI.ENVIRONMENT).postValue(environment);
    }

    @Override
    protected View initScene(Context context) {
        int wp = mWidthPixels;
        int hp = mHeightPixels;

        float fwp_2 = PxUtils.division(wp, 2);
        float fwp_4 = PxUtils.division(wp, 4);
        float fhp_3 = PxUtils.division(hp, 3);
        int wp_2 = PxUtils.round(fwp_2);
        int wp_4 = PxUtils.round(fwp_4);
        int hp_3 =  PxUtils.round(fhp_3);

        float fhp_6 = PxUtils.division(fhp_3, 2);
        int hp_6 = PxUtils.round(fhp_6);

        Container<?> container = new Container<>(context);
        container.setLifecycle(getLifecycle());

        EnvironmentContainer environment = new EnvironmentContainer(context, wp, hp_6);
        Container.LayoutParams envLp = new Container.LayoutParams(wp, hp_6);
        container.addView(environment, envLp);

        BodyDescriptionContainer bodyDescription = new BodyDescriptionContainer(context, wp, hp_6);
        Container.LayoutParams bodyLp = new Container.LayoutParams(wp, hp_6);
        bodyLp.topMargin = hp_6;
        container.addView(bodyDescription, bodyLp);

        int fbHp = PxUtils.round(hp - fhp_3);
        FixedBodyContainer fixedBody = new FixedBodyContainer(context, wp_4, fbHp);
        Container.LayoutParams fixedLp = new Container.LayoutParams(wp_4, fbHp);
        fixedLp.topMargin = hp_3;
        container.addView(fixedBody, fixedLp);

        MovingBodyContainer movingBody = new MovingBodyContainer(context, wp_4, hp_3);
        Container.LayoutParams movingLp = new Container.LayoutParams(wp_4, hp_3, Gravity.END);
        movingLp.topMargin = hp_3;
        container.addView(movingBody, movingLp);

        ActionDescriptionContainer actionDescription = new ActionDescriptionContainer(context, wp_2, hp_3);
        Container.LayoutParams actionLp = new Container.LayoutParams(wp_2, hp_3);
        actionLp.topMargin = hp_3;
        actionLp.leftMargin = wp_4;
        container.addView(actionDescription, actionLp);

        DirectionContainer direction = new DirectionContainer(context, wp_2, hp_3);
        Container.LayoutParams dirLp = new Container.LayoutParams(wp_2, hp_3, Gravity.END);
        dirLp.topMargin = fbHp;
        container.addView(direction, dirLp);

        OperationContainer operation = new OperationContainer(context, wp_4, hp_3);
        Container.LayoutParams opeLp = new Container.LayoutParams(wp_4, hp_3);
        opeLp.topMargin = fbHp;
        opeLp.leftMargin = wp_4;
        container.addView(operation, opeLp);

        return container;
    }
}
