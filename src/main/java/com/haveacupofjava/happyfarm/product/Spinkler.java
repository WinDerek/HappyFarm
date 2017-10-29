package com.haveacupofjava.happyfarm.product;

import com.haveacupofjava.happyfarm.field.AbstractField;

/**
 * @author Create by xuantang
 * @date on 10/29/17
 */
public class Spinkler extends AbstractTool {

    public Spinkler() {
        setName("spinkler");
        setPrice(299D);
    }

    /**
     * Check whether the object is empty
     * @return boolean
     */
    @Override
    public boolean isNil() {
        return false;
    }

    /**
     * Clone the spinkler tool
     * @return spinkler
     */
    @Override
    public Spinkler clone() {
        Spinkler spinkler = new Spinkler();
        spinkler.setName(this.getName());
        return spinkler;
    }

    @Override
    public void handleField(AbstractField filed) {

    }
}
