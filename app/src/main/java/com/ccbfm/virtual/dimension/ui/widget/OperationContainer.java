package com.ccbfm.virtual.dimension.ui.widget;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.ccbfm.virtual.dimension.model.ModelConfig;
import com.ccbfm.virtual.dimension.model.Operate;
import com.ccbfm.virtual.dimension.model.ui.Operation;
import com.ccbfm.virtual.dimension.ui.ColorConfig;
import com.ccbfm.virtual.dimension.ui.widget.base.Container;
import com.ccbfm.virtual.dimension.ui.widget.base.MixDrawable;
import com.ccbfm.virtual.dimension.ui.widget.base.Recycler;
import com.ccbfm.virtual.dimension.ui.widget.base.Text;

public class OperationContainer extends Container<Operation> {
    private static final String TAG = "FixedBodyContainer";
    private static final boolean DEBUG = true;
    private OcAdapter mOcAdapter;

    public OperationContainer(@NonNull Context context) {
        super(context);
    }

    public OperationContainer(@NonNull Context context, int widthPixels, int heightPixels) {
        super(context, widthPixels, heightPixels);
    }

    @Override
    protected void initContainer(Context context) {
        super.initContainer(context);
        int padding = mWidthPixels >> 4;
        mOcAdapter = new OcAdapter(mWidthPixels, mHeightPixels, this);
        Recycler recycler = new Recycler(context);
        recycler.setPadding(padding, padding, padding, padding);
        recycler.setLayoutManager(new LinearLayoutManager(context));
        recycler.addItemDecoration(new Recycler.SpacesItemDecoration(padding).vertical());
        recycler.setAdapter(mOcAdapter);
        LayoutParams recLp = new LayoutParams(mWidthPixels, mHeightPixels);
        addView(recycler, recLp);
    }

    @Override
    protected void setBackground() {
        setBackground(MixDrawable.build().setBorder(2, ColorConfig.CInt.C000000));
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);

    }

    @Override
    protected void liveDataResult(Operation data) {
        super.liveDataResult(data);
        if(data != null){
            mOcAdapter.notifyDataAll(data.getOperates());
        } else {
            mOcAdapter.notifyDataAll(null);
        }

    }

    @Override
    protected String liveDataKey() {
        return ModelConfig.UI.OPERATION;
    }

    private static class OcHolder extends Recycler.RHolder {
        public Text mName;

        public OcHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void setName(Text name) {
            this.mName = name;
        }
    }

    private static class OcAdapter extends Recycler.RAdapter<Operate, OcHolder> {
        private final View.OnClickListener mClickListener;
        private final int mItemHP;

        public OcAdapter(int widthPixels, int heightPixels, OnClickListener clickListener) {
            super(widthPixels, heightPixels);
            this.mClickListener = clickListener;
            mItemHP = (widthPixels >> 1) - (widthPixels >> 3);
        }

        @NonNull
        @Override
        public OcHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            Context context = parent.getContext();

            Container<?> container = new Container<>(context);
            container.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, mItemHP));

            Text text = new Text(context).setClickListener(mClickListener).singleLine().setBorder();

            text.setGravity(Gravity.START | Gravity.CENTER_VERTICAL);
            LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT,
                    LayoutParams.MATCH_PARENT, Gravity.CENTER);
            container.addView(text, lp);

            OcHolder fbHolder = new OcHolder(container);
            fbHolder.setName(text);
            return fbHolder;
        }


        @Override
        public void onBindViewHolder(@NonNull OcHolder holder, int position) {
            Operate operate = getData(position);

            holder.mName.setText(operate.getName());
            holder.mName.setTag(operate);

        }

    }
}
