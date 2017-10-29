package com.haveacupofjava.happyfarm.product;

/**
 * @author Create by xuantang
 * @date on 10/29/17
 */
public class Purse extends AbstractDaily {
    public Purse() {
        setName("purse");
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
     * Clone the purse daily product
     * @return purse
     */
    @Override
    public AbstractProduct clone() {
        Purse purse = new Purse();
        purse.setName(this.getName());
        return purse;
    }
}
