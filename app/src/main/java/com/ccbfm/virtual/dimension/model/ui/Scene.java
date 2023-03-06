package com.ccbfm.virtual.dimension.model.ui;

import com.ccbfm.virtual.dimension.model.Model;

import java.util.List;

public class Scene extends Model {

    protected Environment environment;

    protected Operation operation;

    protected List<FixedBody> fixedBodyList;

    protected List<MovingBody> movingBodyList;

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public List<FixedBody> getFixedBodyList() {
        return fixedBodyList;
    }

    public void setFixedBodyList(List<FixedBody> fixedBodyList) {
        this.fixedBodyList = fixedBodyList;
    }

    public List<MovingBody> getMovingBodyList() {
        return movingBodyList;
    }

    public void setMovingBodyList(List<MovingBody> movingBodyList) {
        this.movingBodyList = movingBodyList;
    }
}
