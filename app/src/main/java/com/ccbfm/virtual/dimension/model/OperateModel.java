package com.ccbfm.virtual.dimension.model;

import java.util.LinkedList;
import java.util.List;

public class OperateModel extends Model {

    protected List<Operate> operates = new LinkedList<>();

    public List<Operate> getOperates() {
        return operates;
    }

    public void setOperates(List<Operate> operates) {
        this.operates.clear();
        this.operates.addAll(operates);
    }
}
