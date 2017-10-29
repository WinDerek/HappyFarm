package com.haveacupofjava.happyfarm.product;

import com.haveacupofjava.happyfarm.field.AbstractField;

public abstract class AbstractTool extends AbstractProduct {

    public AbstractTool() {}

    /**
     * Handles the field
     * @param field The field to be handled
     */
    public abstract void handleField(AbstractField field);

}
