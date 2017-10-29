package com.haveacupofjava.happyfarm.product;

/**
 * @author Create by xuantang
 * @date on 10/29/17
 */
public class Bed extends AbstractFurniture {

    public Bed(){
        setName("bed");
        setPrice(2999D);
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
     * Clone the bed product
     * @return new bed
     */
    @Override
    public Bed clone() {
        Bed bed = new Bed();
        bed.setName(this.getName());
        return bed;
    }
}
