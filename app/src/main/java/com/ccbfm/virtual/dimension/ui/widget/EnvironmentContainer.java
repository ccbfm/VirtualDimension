package com.ccbfm.virtual.dimension.ui.widget;

import android.content.Context;
import android.view.Gravity;
import android.view.View;

import androidx.annotation.NonNull;

import com.ccbfm.virtual.dimension.model.ModelConfig;
import com.ccbfm.virtual.dimension.model.ui.Environment;
import com.ccbfm.virtual.dimension.ui.ColorConfig;
import com.ccbfm.virtual.dimension.ui.widget.base.Container;
import com.ccbfm.virtual.dimension.ui.widget.base.MixDrawable;
import com.ccbfm.virtual.dimension.ui.widget.base.Scroll;
import com.ccbfm.virtual.dimension.ui.widget.base.Text;

public class EnvironmentContainer extends Container<Environment> {
    private static final String TAG = "MovingBodyContainer";
    private static final boolean DEBUG = true;

    private Text mTitle, mDescription, mWeather, mTime;
    private Scroll mScroll;

    public EnvironmentContainer(@NonNull Context context) {
        super(context);
    }

    public EnvironmentContainer(@NonNull Context context, int widthPixels, int heightPixels) {
        super(context, widthPixels, heightPixels);
    }

    @Override
    protected void initContainer(Context context) {
        super.initContainer(context);

        int hh = mHeightPixels >> 1;
        int fh = mHeightPixels >> 2;

        int th = hh + fh;
        int tw = th;
        int ew = (mWidthPixels - tw);

        Text title = new Text(context).singleLine().bold();
        title.setGravity(Gravity.START | Gravity.CENTER_VERTICAL);
        LayoutParams titleLp = new LayoutParams(ew, fh);
        addView(title, titleLp);
        mTitle = title;

        Scroll scroll = new Scroll(context);
        Text description = new Text(context);
        Scroll.LayoutParams infoLp = new Scroll.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        scroll.addView(description, infoLp);
        mDescription = description;

        LayoutParams scLp = new LayoutParams(ew, LayoutParams.MATCH_PARENT);
        scLp.topMargin = fh;
        addView(scroll, scLp);
        mScroll = scroll;

        Text weather = new Text(context).setBorder().singleLine();
        weather.setGravity(Gravity.START | Gravity.CENTER_VERTICAL);
        LayoutParams weatherLp = new LayoutParams(th, fh);
        weatherLp.gravity = Gravity.END;
        addView(weather, weatherLp);
        mWeather = weather;

        Text time = new Text(context).setBorder().singleLine();
        LayoutParams timeLp = new LayoutParams(th, th);
        timeLp.gravity = Gravity.END;
        timeLp.topMargin = fh;
        addView(time, timeLp);
        mTime = time;
    }

    @Override
    protected void setBackground() {
        setBackground(MixDrawable.build().setBorder(2, ColorConfig.CInt.C000000));
    }

    @Override
    protected void liveDataResult(Environment data) {
        super.liveDataResult(data);
        if(data != null){
            mTitle.append(data.getName());
            mDescription.setText(data.getDescription());
            mScroll.fullScroll(View.FOCUS_UP);
        } else {
            mTitle.setText("");
            mDescription.setText("");
        }
    }

    @Override
    protected String liveDataKey() {
        return ModelConfig.UI.ENVIRONMENT;
    }
}
