package com.ccbfm.virtual.dimension.ui.widget.base;

import android.content.Context;
import android.graphics.Typeface;
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
