package com.ccbfm.virtual.dimension.ui.widget.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;
import java.util.List;

public class Recycler extends RecyclerView {

    public Recycler(@NonNull Context context) {
        super(context);
        //去除边界特效
        setOverScrollMode(OVER_SCROLL_NEVER);
    }


    public static class RHolder extends RecyclerView.ViewHolder {

        public RHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public static abstract class RAdapter<D, RH extends RHolder> extends RecyclerView.Adapter<RH> {
        protected final List<D> mDataList = new LinkedList<>();
        protected int mWidthPixels, mHeightPixels;

        public RAdapter(int widthPixels, int heightPixels) {
            this.mWidthPixels = widthPixels;
            this.mHeightPixels = heightPixels;
        }

        @SuppressLint("NotifyDataSetChanged")
        public void notifyDataAll(List<D> dataList){
            this.mDataList.clear();
            if(dataList != null) {
                this.mDataList.addAll(dataList);
            }
            notifyDataSetChanged();
        }

        @Override
        public int getItemCount() {
            return mDataList.size();
        }

        protected D getData(int position){
            return mDataList.get(position);
        }
    }

    public static class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        private int mDirection = RecyclerView.HORIZONTAL;
        private final int mSpace;

        public SpacesItemDecoration(int space) {
            this.mSpace = space;
        }

        public SpacesItemDecoration vertical(){
            mDirection = RecyclerView.VERTICAL;
            return this;
        }

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view,
                                   @NonNull RecyclerView parent, @NonNull State state) {
            if(mDirection == RecyclerView.HORIZONTAL){
                outRect.left = mSpace;
                outRect.right = mSpace;
            } else if(mDirection == RecyclerView.VERTICAL){
                outRect.top = mSpace;
                outRect.bottom = mSpace;
            }
        }
    }
}
