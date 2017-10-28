package com.haveacupofjava.happyfarm.product;

import com.haveacupofjava.happyfarm.field.AbstractField;

public abstract class AbstractTool extends AbstractProduct {

    public AbstractTool() {}

    public abstract void handleField(AbstractField field);

}
