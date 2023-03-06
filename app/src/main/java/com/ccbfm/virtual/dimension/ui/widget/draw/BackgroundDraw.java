package com.ccbfm.virtual.dimension.ui.widget.draw;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;

public class BackgroundDraw extends BaseDraw {

    private Paint mPaint;
    private float mRadius;
    private Rect mRect;
    private RectF mRectF;
    private boolean mIsDirty;

    public BackgroundDraw(Drawable drawable) {
        super(drawable);
    }

    public void setBorder(int border) {
        this.setBorder(border, border, border, border);
    }

    public void setBorder(int left, int top, int right, int bottom) {
        this.mRect = new Rect(left, top, right, bottom);
        mIsDirty = true;
    }

    public void setCornerRadius(float radius) {
        this.mRadius = radius;
    }

    public void setColor(@ColorInt int color) {
        setStrokeInternal(color);
    }

    private void setStrokeInternal(int color) {
        if (mPaint == null) {
            mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            mPaint.setStyle(Paint.Style.FILL);
        }
        mPaint.setColor(color);
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        if (!ensureValidRect()) {
            return;
        }
        if (mPaint != null) {
            canvas.drawRoundRect(mRectF, mRadius, mRadius, mPaint);
        }
    }

    private boolean ensureValidRect() {
        float left = 0, top = 0, right = 0, bottom = 0;
        if (mIsDirty) {
            mIsDirty = false;
            Rect bf = mRect;
            Rect bounds = getBounds();

            left = bounds.left + bf.left;
            top = bounds.top + bf.top;
            right = bounds.right - bf.right;
            bottom = bounds.bottom - bf.bottom;
        } else if (mRectF == null) {
            Rect bounds = getBounds();
            left = bounds.left;
            top = bounds.top;
            right = bounds.right;
            bottom = bounds.bottom;
        }

        if (left < right && top < bottom) {
            mRectF = new RectF(left, top, right, bottom);
        }
        return !mRectF.isEmpty();
    }

}
