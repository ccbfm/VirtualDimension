package com.ccbfm.virtual.dimension.ui.widget.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ccbfm.virtual.dimension.model.ui.FixedBody;

import java.util.LinkedList;
import java.util.List;

public class Recycler extends RecyclerView {

    public Recycler(@NonNull Context context) {
        super(context);
    }


    public static class RHolder extends RecyclerView.ViewHolder {

        public RHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public static abstract class RAdapter<D, RH extends RHolder> extends RecyclerView.Adapter<RH> {
        protected final List<D> mDataList = new LinkedList<>();

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
}
