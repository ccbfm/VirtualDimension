package com.ccbfm.virtual.dimension.ui.widget.base;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.TypedValue;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;

import com.ccbfm.virtual.dimension.ui.ColorConfig;

public class Text extends AppCompatTextView {

    public Text(@NonNull Context context) {
        super(context);
        init(context);
    }

    protected void init(Context context) {
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
    }

    public Text setBorder() {
        return setBorder(ColorConfig.CString.C000000, ColorConfig.CString.CFFFFFF);
    }

    public Text setBorder(String borderColorString, String backgroundColorString) {
        GradientDrawable drawable = new GradientDrawable();

        if (!TextUtils.isEmpty(borderColorString)) {
            // 设置圆角弧度
            drawable.setCornerRadius(1);
            // 设置边框线的粗细，颜色
            drawable.setStroke(1, Color.parseColor(borderColorString));
            setPadding(1, 1, 1, 1);
        }

        if (!TextUtils.isEmpty(backgroundColorString)) {
            drawable.setColor(Color.parseColor(backgroundColorString));
        }
        setBackground(drawable);
        return this;
    }

    public Text vertical() {
        setEms(1);
        return this;
    }

    public Text singleLine() {
        setLines(1);
        setEllipsize(TextUtils.TruncateAt.END);
        return this;
    }

    public Text bold() {
        setTypeface(Typeface.DEFAULT_BOLD);
        return this;
    }

    public Text setClickListener(OnClickListener clickListener) {
        setOnClickListener(clickListener);
        return this;
    }

}
