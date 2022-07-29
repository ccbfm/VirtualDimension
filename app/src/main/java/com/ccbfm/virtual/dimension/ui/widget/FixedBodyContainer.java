package com.ccbfm.virtual.dimension.ui.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.ccbfm.virtual.dimension.model.ModelConfig;
import com.ccbfm.virtual.dimension.model.ui.FixedBody;
import com.ccbfm.virtual.dimension.ui.widget.base.Container;
import com.ccbfm.virtual.dimension.ui.widget.base.Recycler;
import com.ccbfm.virtual.dimension.ui.widget.base.Text;

import java.util.List;

public class FixedBodyContainer extends Container<List<FixedBody>> {
    private static final String TAG = "FixedBodyContainer";
    private static final boolean DEBUG = true;
    private FBAdapter mFbAdapter;

    public FixedBodyContainer(@NonNull Context context) {
        super(context);
    }

    public FixedBodyContainer(@NonNull Context context, int widthPixels, int heightPixels) {
        super(context, widthPixels, heightPixels);
    }

    @Override
    protected void initContainer(Context context) {
        super.initContainer(context);
        mFbAdapter = new FBAdapter();
        Recycler recycler = new Recycler(context);
        recycler.setLayoutManager(new LinearLayoutManager(context));
        recycler.setAdapter(mFbAdapter);
        LayoutParams recLp = new LayoutParams(mWidthPixels, mHeightPixels);
        addView(recycler, recLp);
    }

    @Override
    protected void liveDataResult(List<FixedBody> data) {
        super.liveDataResult(data);
        mFbAdapter.notifyDataAll(data);
    }

    @Override
    protected String liveDataKey() {
        return ModelConfig.UI.FIXED_BODY;
    }

    private static class FBHolder extends Recycler.RHolder {

        public FBHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    private static class FBAdapter extends Recycler.RAdapter<FixedBody, FBHolder> {

        @NonNull
        @Override
        public FBHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            Text text = new Text(context);
            text.setText("111");
            return new FBHolder(text);
        }


        @Override
        public void onBindViewHolder(@NonNull FBHolder holder, int position) {
            FixedBody fixedBody = getData(position);
        }

    }
}
