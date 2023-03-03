package com.ccbfm.virtual.dimension.ui.widget.draw;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;

public class BorderDraw extends BaseDraw {

    private Paint mStrokePaint;
    private Path mPath;
    private Rect mBorderRect;
    private boolean mGradientIsDirty;

    public BorderDraw(Drawable drawable) {
        super(drawable);
    }

    public void setColor(@ColorInt int color) {

    }

    public void setBorder(int border) {
        this.setBorder(border, border, border, border);
    }

    public void setBorder(int left, int top, int right, int bottom) {
        this.mBorderRect = new Rect(left, top, right, bottom);
        mGradientIsDirty = true;
    }

    public void setCornerRadius(float radius) {
    }

    public void setStroke(int width, @ColorInt int color) {
        setStroke(width, color, 0, 0);
    }

    public void setStroke(int width, @ColorInt int color, float dashWidth, float dashGap) {
        setStrokeInternal(width, color, dashWidth, dashGap);
    }

    private void setStrokeInternal(int width, int color, float dashWidth, float dashGap) {
        if (mStrokePaint == null) {
            mStrokePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            mStrokePaint.setStyle(Paint.Style.STROKE);
        }
        mStrokePaint.setStrokeWidth(width);
        mStrokePaint.setColor(color);

        DashPathEffect e = null;
        if (dashWidth > 0) {
            e = new DashPathEffect(new float[]{dashWidth, dashGap}, 0);
        }
        mStrokePaint.setPathEffect(e);
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        if (!ensureValidRect()) {
            return;
        }
        if (mStrokePaint != null) {
            canvas.drawPath(mPath, mStrokePaint);
        }
    }

    private boolean ensureValidRect() {
        float left = 0, top = 0, right = 0, bottom = 0;
        if (mGradientIsDirty) {
            mGradientIsDirty = false;
            Rect bf = mBorderRect;
            Rect bounds = getBounds();

            left = bounds.left + bf.left;
            top = bounds.top + bf.top;
            right = bounds.right - bf.right;
            bottom = bounds.bottom - bf.bottom;
        } else if (mPath == null) {
            Rect bounds = getBounds();
            left = bounds.left;
            top = bounds.top;
            right = bounds.right;
            bottom = bounds.bottom;
        }

        if (left <= right && top <= bottom) {
            mPath = new Path();
            mPath.moveTo(left, top);
            mPath.lineTo(left, bottom);
            mPath.lineTo(right, bottom);
            mPath.lineTo(right, top);
            mPath.close();
        }
        return !mPath.isEmpty();
    }

}
