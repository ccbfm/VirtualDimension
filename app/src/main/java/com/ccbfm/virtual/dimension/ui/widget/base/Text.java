package com.ccbfm.virtual.dimension.ui.widget.base;

import android.content.Context;
import android.util.TypedValue;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;

public class Text extends AppCompatTextView {


    public Text(@NonNull Context context) {
        super(context);
        init(context);
    }

    protected void init(Context context){
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
    }

    public Text vertical(){
        setEms(1);
        return this;
    }
}
