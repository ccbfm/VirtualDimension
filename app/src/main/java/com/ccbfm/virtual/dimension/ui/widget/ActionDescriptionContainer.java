package com.ccbfm.virtual.dimension.ui.widget;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import com.ccbfm.virtual.dimension.model.ui.ActionDescription;
import com.ccbfm.virtual.dimension.model.ModelConfig;
import com.ccbfm.virtual.dimension.model.ui.FixedBody;
import com.ccbfm.virtual.dimension.ui.widget.base.Container;
import com.ccbfm.virtual.dimension.utils.LogUtils;
import com.ccbfm.virtual.dimension.utils.livedata.LiveDataBus;

import java.util.LinkedList;
import java.util.List;

public class ActionDescriptionContainer extends Container<ActionDescription> {
    private static final String TAG = "ActionDescriptionContainer";
    private static final boolean DEBUG = true;

    public ActionDescriptionContainer(@NonNull Context context) {
        super(context);
    }

    public ActionDescriptionContainer(@NonNull Context context, int widthPixels, int heightPixels) {
        super(context, widthPixels, heightPixels);
    }

    private int count = 10;
    @Override
    protected void initContainer(Context context) {
        super.initContainer(context);

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtils.d(TAG, "onClick--=" + count, DEBUG);
                List<FixedBody> list = new LinkedList<>();
                for (int i = 0; i < count; i++) {
                    list.add(new FixedBody());
                }
                LiveDataBus.get().<List<FixedBody>>with(ModelConfig.UI.FIXED_BODY).postValue(list);
                count += 5;
            }
        });
    }

    @Override
    protected void liveDataResult(ActionDescription data) {
        super.liveDataResult(data);
    }

    @Override
    protected String liveDataKey() {
        return ModelConfig.UI.ACTION_DESCRIPTION;
    }
}
