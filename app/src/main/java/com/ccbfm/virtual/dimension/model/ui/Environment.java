package com.ccbfm.virtual.dimension.model.ui;

import androidx.annotation.NonNull;

import com.ccbfm.virtual.dimension.model.Model;

public class Environment extends Model {

    @NonNull
    @Override
    public String toString() {
        return this.getName() + "\n" + this.getDescription();
    }
}
