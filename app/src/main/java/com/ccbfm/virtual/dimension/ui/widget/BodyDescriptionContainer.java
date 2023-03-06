package com.ccbfm.virtual.dimension.ui.widget;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;

import androidx.annotation.NonNull;

import com.ccbfm.virtual.dimension.model.ModelConfig;
import com.ccbfm.virtual.dimension.model.ui.BodyDescription;
import com.ccbfm.virtual.dimension.ui.ColorConfig;
import com.ccbfm.virtual.dimension.ui.PxConfig;
import com.ccbfm.virtual.dimension.ui.widget.base.Container;
import com.ccbfm.virtual.dimension.ui.widget.base.MixDrawable;
import com.ccbfm.virtual.dimension.ui.widget.base.Scroll;
import com.ccbfm.virtual.dimension.ui.widget.base.Text;

public class BodyDescriptionContainer extends Container<BodyDescription> {
    private static final String TAG = "FixedBodyContainer";
    private static final boolean DEBUG = true;
    private Text mTitle, mDescription;
    private Scroll mScroll;

    public BodyDescriptionContainer(@NonNull Context context) {
        super(context);
    }

    public BodyDescriptionContainer(@NonNull Context context, int widthPixels, int heightPixels) {
        super(context, widthPixels, heightPixels);
    }

    @Override
    protected void initContainer(Context context) {
        super.initContainer(context);

        Scroll scroll = new Scroll(context);
        int tHp = mHeightPixels >> 2;
        Text title = new Text(context).singleLine().bold();
        title.setGravity(Gravity.START | Gravity.CENTER_VERTICAL);
        LayoutParams titleLp = new LayoutParams(LayoutParams.MATCH_PARENT, tHp);
        addView(title, titleLp);
        mTitle = title;

        Text description = new Text(context);
        Scroll.LayoutParams infoLp = new Scroll.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        scroll.addView(description, infoLp);
        mDescription = description;

        LayoutParams scLp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        scLp.topMargin = tHp;
        addView(scroll, scLp);
        mScroll = scroll;
    }

    @Override
    protected void setBackground() {
        setBackground(MixDrawable.build().setBorder(PxConfig.PxInt.CONTAINER_BORDER, ColorConfig.CInt.CCD5B45));
    }

    @Override
    protected void liveDataResult(BodyDescription data) {
        super.liveDataResult(data);
        if(data != null){
            mTitle.setText(data.getName());
            mDescription.setText(data.getDescription());
            mScroll.fullScroll(View.FOCUS_UP);
        } else {
            mTitle.setText("");
            mDescription.setText("");
        }
    }

    @Override
    protected String liveDataKey() {
        return ModelConfig.UI.BODY_DESCRIPTION;
    }
}
