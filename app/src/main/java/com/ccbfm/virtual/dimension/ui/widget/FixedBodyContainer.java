package com.ccbfm.virtual.dimension.ui.widget;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.ccbfm.virtual.dimension.model.ModelConfig;
import com.ccbfm.virtual.dimension.model.ui.BodyDescription;
import com.ccbfm.virtual.dimension.model.ui.FixedBody;
import com.ccbfm.virtual.dimension.model.ui.Operation;
import com.ccbfm.virtual.dimension.ui.widget.base.Container;
import com.ccbfm.virtual.dimension.ui.widget.base.Recycler;
import com.ccbfm.virtual.dimension.ui.widget.base.Text;
import com.ccbfm.virtual.dimension.utils.livedata.LiveDataBus;

import java.util.List;

public class FixedBodyContainer extends Container<List<FixedBody>> {
    private static final String TAG = "FixedBodyContainer";
    private static final boolean DEBUG = true;
    private FbAdapter mFbAdapter;

    public FixedBodyContainer(@NonNull Context context) {
        super(context);
    }

    public FixedBodyContainer(@NonNull Context context, int widthPixels, int heightPixels) {
        super(context, widthPixels, heightPixels);
    }

    @Override
    protected void initContainer(Context context) {
        super.initContainer(context);
        int padding = mWidthPixels >> 4;
        mFbAdapter = new FbAdapter(mWidthPixels, mHeightPixels, this);
        Recycler recycler = new Recycler(context);
        recycler.setPadding(padding, padding, padding, padding);
        recycler.setLayoutManager(new LinearLayoutManager(context));
        recycler.addItemDecoration(new Recycler.SpacesItemDecoration(padding).vertical());
        recycler.setAdapter(mFbAdapter);
        LayoutParams recLp = new LayoutParams(mWidthPixels, mHeightPixels);
        addView(recycler, recLp);

        setBorder();
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        Object tag = v.getTag();
        if (tag instanceof FixedBody) {
            FixedBody fixedBody = (FixedBody) tag;

            BodyDescription bodyDescription = new BodyDescription(fixedBody);
            LiveDataBus.get().<BodyDescription>with(ModelConfig.UI.BODY_DESCRIPTION).postValue(bodyDescription);

            Operation operation = new Operation(fixedBody);
            LiveDataBus.get().<Operation>with(ModelConfig.UI.OPERATION).postValue(operation);
        }
    }

    @Override
    protected void liveDataResult(List<FixedBody> data) {
        super.liveDataResult(data);
        mFbAdapter.notifyDataAll(data);

        LiveDataBus.get().<BodyDescription>with(ModelConfig.UI.BODY_DESCRIPTION).postValue(null);
        LiveDataBus.get().<Operation>with(ModelConfig.UI.OPERATION).postValue(null);
    }

    @Override
    protected String liveDataKey() {
        return ModelConfig.UI.FIXED_BODY;
    }

    private static class FbHolder extends Recycler.RHolder {
        public Text mName;

        public FbHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void setName(Text name) {
            this.mName = name;
        }
    }

    private static class FbAdapter extends Recycler.RAdapter<FixedBody, FbHolder> {
        private final View.OnClickListener mClickListener;
        private final int mItemHP;

        public FbAdapter(int widthPixels, int heightPixels, OnClickListener clickListener) {
            super(widthPixels, heightPixels);
            this.mClickListener = clickListener;
            mItemHP = (widthPixels >> 1) - (widthPixels >> 3);
        }

        @NonNull
        @Override
        public FbHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            Context context = parent.getContext();

            Container<?> container = new Container<>(context);
            container.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, mItemHP));

            Text text = new Text(context).setClickListener(mClickListener).singleLine().setBorder();

            text.setGravity(Gravity.START | Gravity.CENTER_VERTICAL);
            LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT,
                    LayoutParams.MATCH_PARENT, Gravity.CENTER);
            container.addView(text, lp);

            FbHolder fbHolder = new FbHolder(container);
            fbHolder.setName(text);
            return fbHolder;
        }


        @Override
        public void onBindViewHolder(@NonNull FbHolder holder, int position) {
            FixedBody fixedBody = getData(position);

            holder.mName.setText(fixedBody.getName());
            holder.mName.setTag(fixedBody);

        }

    }
}
