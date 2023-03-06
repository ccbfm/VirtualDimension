package com.ccbfm.virtual.dimension.ui.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;

import androidx.annotation.NonNull;

import com.ccbfm.virtual.dimension.model.ModelConfig;
import com.ccbfm.virtual.dimension.model.ui.ActionDescription;
import com.ccbfm.virtual.dimension.ui.ColorConfig;
import com.ccbfm.virtual.dimension.ui.PxConfig;
import com.ccbfm.virtual.dimension.ui.widget.base.Container;
import com.ccbfm.virtual.dimension.ui.widget.base.MixDrawable;
import com.ccbfm.virtual.dimension.ui.widget.base.Scroll;
import com.ccbfm.virtual.dimension.ui.widget.base.Text;

public class ActionDescriptionContainer extends Container<ActionDescription> {
    private static final String TAG = "ActionDescriptionContainer";
    private static final boolean DEBUG = true;

    private Text mDescription;
    private Scroll mScroll;

    public ActionDescriptionContainer(@NonNull Context context) {
        super(context);
    }

    public ActionDescriptionContainer(@NonNull Context context, int widthPixels, int heightPixels) {
        super(context, widthPixels, heightPixels);
    }

    @Override
    protected void initContainer(Context context) {
        super.initContainer(context);

        Scroll scroll = new Scroll(context);

        Text description = new Text(context);
        Scroll.LayoutParams desLp = new Scroll.LayoutParams(Scroll.LayoutParams.MATCH_PARENT,
                Scroll.LayoutParams.MATCH_PARENT);
        scroll.addView(description, desLp);
        mDescription = description;

        LayoutParams scrollLp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        addView(scroll, scrollLp);
        mScroll = scroll;
    }

    @Override
    protected void setBackground() {
        setBackground(MixDrawable.build().setBorder(PxConfig.PxInt.CONTAINER_BORDER, ColorConfig.CInt.C8B0A50));
    }

    @Override
    protected void liveDataResult(ActionDescription data) {
        super.liveDataResult(data);
        if (data != null) {
            mDescription.append(data.toString());
            mDescription.append("\n");
            mScroll.fullScroll(View.FOCUS_DOWN);
        } else {
            mDescription.setText("");
        }
    }

    @Override
    protected String liveDataKey() {
        return ModelConfig.UI.ACTION_DESCRIPTION;
    }
}
