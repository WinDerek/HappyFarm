package com.haveacupofjava.happyfarm.product;

import com.haveacupofjava.happyfarm.field.AbstractField;

/**
 * @author Create by xuantang
 * @date on 10/29/17
 */
public class Sickle extends AbstractTool{
    public Sickle() {
        setName("sickle");
        setPrice(59D);
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
     * Clone the sickle tool
     * @return sickle
     */
    @Override
    public Sickle clone(){
        Sickle sickle = new Sickle();
        sickle.setName(this.getName());
        return sickle;
    }

    @Override
    public void handleField(AbstractField filed) {

    }
}
