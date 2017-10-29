package com.haveacupofjava.happyfarm.product;

import com.haveacupofjava.happyfarm.field.AbstractField;

/**
 * @author Create by xuantang
 * @date on 10/29/17
 */
public abstract class AbstractTool extends AbstractProduct {

    public AbstractTool() {}

    public abstract void handleField(AbstractField field);

}
