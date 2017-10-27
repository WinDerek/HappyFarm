package com.haveacupofjava.happyfarm.product;

import com.haveacupofjava.happyfarm.field.AbstractField;

public abstract class AbstractTool extends AbstractProduct{
    /**
      * to handle Field command
      * @author Yiqun Lin
      */
    public abstract void handleField(AbstractField filed);
}
