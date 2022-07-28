package com.ccbfm.virtual.dimension.ui.widget.base;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Recycler extends RecyclerView {

    public Recycler(@NonNull Context context) {
        super(context);
    }


    public static class VHolder extends RecyclerView.ViewHolder {

        public VHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
