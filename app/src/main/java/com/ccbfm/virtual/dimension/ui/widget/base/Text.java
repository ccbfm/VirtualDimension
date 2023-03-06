package com.ccbfm.virtual.dimension.ui.widget.base;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.TypedValue;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;

import com.ccbfm.virtual.dimension.ui.ColorConfig;
import com.ccbfm.virtual.dimension.ui.PxConfig;

public class Text extends AppCompatTextView {
    protected int mPadding;

    public Text(@NonNull Context context) {
        super(context);
        init(context);
    }

    protected void init(Context context) {
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
    }

    public Text border() {
        return border(PxConfig.PxInt.TEXT_BORDER, ColorConfig.CInt.C000000);
    }

    public Text border(int border, int borderColor) {
        setPadding(border);
        setBackground(MixDrawable.build().setBorder(border, borderColor));
        return this;
    }

    protected void setPadding(int padding) {
        if (this.mPadding < padding) {
            this.mPadding = padding;
        }
    }

    public Text padding(){
        return padding(this.mPadding);
    }

    public Text padding(int padding){
        if (this.mPadding < padding) {
            this.mPadding = padding;
        }
        int n_p = this.mPadding + PxConfig.PxInt.TEXT_PADDING;
        setPadding(n_p, n_p, n_p, n_p);
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
