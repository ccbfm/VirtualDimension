package com.ccbfm.virtual.dimension.ui.widget.base;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ccbfm.virtual.dimension.ui.widget.draw.BorderDraw;
import com.ccbfm.virtual.dimension.ui.widget.draw.IDraw;

import java.util.LinkedList;

public class MixDrawable extends Drawable {

    public static MixDrawable build() {
        return new MixDrawable();
    }

    private final LinkedList<IDraw> mDraws = new LinkedList<>();

    public MixDrawable setBorder(int border, int borderColor) {
        BorderDraw borderDraw = new BorderDraw(this);
        // 设置圆角弧度
        borderDraw.setCornerRadius(1);
        // 设置边框线的粗细，颜色
        borderDraw.setStroke(1, borderColor);
        borderDraw.setBorder(border);
        this.mDraws.add(borderDraw);
        return this;
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        for (IDraw draw : this.mDraws) {
            draw.draw(canvas);
        }
    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.OPAQUE;
    }
}
