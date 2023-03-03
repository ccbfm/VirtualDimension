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
import com.ccbfm.virtual.dimension.model.ui.MovingBody;
import com.ccbfm.virtual.dimension.model.ui.Operation;
import com.ccbfm.virtual.dimension.ui.ColorConfig;
import com.ccbfm.virtual.dimension.ui.widget.base.Container;
import com.ccbfm.virtual.dimension.ui.widget.base.MixDrawable;
import com.ccbfm.virtual.dimension.ui.widget.base.Recycler;
import com.ccbfm.virtual.dimension.ui.widget.base.Text;
import com.ccbfm.virtual.dimension.utils.livedata.LiveDataBus;

import java.util.List;

public class MovingBodyContainer extends Container<List<MovingBody>> {
    private static final String TAG = "MovingBodyContainer";
    private static final boolean DEBUG = true;
    private MbAdapter mMbAdapter;

    public MovingBodyContainer(@NonNull Context context) {
        super(context);
    }

    public MovingBodyContainer(@NonNull Context context, int widthPixels, int heightPixels) {
        super(context, widthPixels, heightPixels);
    }

    @Override
    protected void initContainer(Context context) {
        super.initContainer(context);

        int padding = mWidthPixels >> 4;
        mMbAdapter = new MbAdapter(mWidthPixels, mHeightPixels, this);
        Recycler recycler = new Recycler(context);
        recycler.setPadding(padding, padding, padding, padding);
        recycler.setLayoutManager(new LinearLayoutManager(context));
        recycler.addItemDecoration(new Recycler.SpacesItemDecoration(padding).vertical());
        recycler.setAdapter(mMbAdapter);
        LayoutParams recLp = new LayoutParams(mWidthPixels, mHeightPixels);
        addView(recycler, recLp);
    }

    @Override
    protected void setBackground() {
        setBackground(MixDrawable.build().setBorder(2, ColorConfig.CInt.C000000));
    }

    @Override
    protected void liveDataResult(List<MovingBody> data) {
        super.liveDataResult(data);
        mMbAdapter.notifyDataAll(data);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        Object tag = v.getTag();
        if (tag instanceof MovingBody) {
            MovingBody movingBody = (MovingBody) tag;

            BodyDescription bodyDescription = new BodyDescription(movingBody);
            LiveDataBus.get().<BodyDescription>with(ModelConfig.UI.BODY_DESCRIPTION).postValue(bodyDescription);

            Operation operation = new Operation(movingBody);
            LiveDataBus.get().<Operation>with(ModelConfig.UI.OPERATION).postValue(operation);
        }
    }

    @Override
    protected String liveDataKey() {
        return ModelConfig.UI.MOVING_BODY;
    }

    private static class MbHolder extends Recycler.RHolder {
        public Text mName;

        public MbHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void setName(Text name) {
            this.mName = name;
        }
    }

    private static class MbAdapter extends Recycler.RAdapter<MovingBody, MbHolder> {
        private final View.OnClickListener mClickListener;
        private final int mItemHP;

        public MbAdapter(int widthPixels, int heightPixels, OnClickListener clickListener) {
            super(widthPixels, heightPixels);
            this.mClickListener = clickListener;
            mItemHP = (widthPixels >> 1) - (widthPixels >> 3);
        }

        @NonNull
        @Override
        public MbHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            Context context = parent.getContext();

            Container<?> container = new Container<>(context);
            container.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, mItemHP));

            Text text = new Text(context).setClickListener(mClickListener).singleLine().setBorder();

            text.setGravity(Gravity.START | Gravity.CENTER_VERTICAL);
            LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT,
                    LayoutParams.MATCH_PARENT, Gravity.CENTER);
            container.addView(text, lp);

            MbHolder fbHolder = new MbHolder(container);
            fbHolder.setName(text);
            return fbHolder;
        }


        @Override
        public void onBindViewHolder(@NonNull MbHolder holder, int position) {
            MovingBody movingBody = getData(position);

            holder.mName.setText(movingBody.getName());
            holder.mName.setTag(movingBody);

        }

    }
}
