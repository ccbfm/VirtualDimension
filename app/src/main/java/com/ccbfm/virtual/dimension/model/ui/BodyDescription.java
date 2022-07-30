package com.ccbfm.virtual.dimension.model.ui;

import com.ccbfm.virtual.dimension.model.Model;

public class BodyDescription extends Model {

    public BodyDescription() {
    }

    public BodyDescription(Model model) {
        setName(model.getName());
        setDescription(model.getDescription());
    }
}
