package com.haveacupofjava.happyfarm.product;

import com.haveacupofjava.happyfarm.field.AbstractField;

/**
 * @author Create by xuantang
 * @date on 10/29/17
 */
public class Hoe extends AbstractTool{

    public Hoe() {
        setName("hoe");
        setPrice(99D);
    }

    /**
     * Check whether the object is empty
     * @return false
     */
    @Override
    public boolean isNil() {
        return false;
    }

    /**
     * Clone the desk product
     * @return desk
     */
    @Override
    public Hoe clone() {
        Hoe hoe = new Hoe();
        hoe.setName(this.getName());
        return hoe;
    }

    @Override
    public void handleField(AbstractField filed) {

    }
}


