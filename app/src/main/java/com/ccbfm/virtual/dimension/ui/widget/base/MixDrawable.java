package com.ccbfm.virtual.dimension.ui.widget.base;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ccbfm.virtual.dimension.ui.widget.draw.BackgroundDraw;
import com.ccbfm.virtual.dimension.ui.widget.draw.BorderDraw;
import com.ccbfm.virtual.dimension.ui.widget.draw.IDraw;

import java.util.LinkedList;

public class MixDrawable extends Drawable {

    public static MixDrawable build() {
        return new MixDrawable();
    }

    private final LinkedList<IDraw> mDraws = new LinkedList<>();

    public MixDrawable setBorder(int border, int color) {
        BorderDraw draw = new BorderDraw(this);
        // 设置圆角弧度
        draw.setCornerRadius(1);
        // 设置边框线的粗细，颜色
        draw.setStroke(1, color);
        draw.setBorder(border);
        this.mDraws.add(draw);
        return this;
    }

    public MixDrawable setBackground(int border, int color){
        BackgroundDraw draw = new BackgroundDraw(this);
        // 设置圆角弧度
        draw.setCornerRadius(1);
        // 设置边框线的粗细，颜色
        draw.setColor(color);
        //borderDraw.setBorder(border);
        this.mDraws.add(draw);
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
