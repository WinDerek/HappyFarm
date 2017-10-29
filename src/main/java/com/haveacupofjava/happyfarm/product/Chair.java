package com.haveacupofjava.happyfarm.product;

/**
 * @author Create by xuantang
 * @date on 10/29/17
 */
public class Chair extends AbstractFurniture {

    public Chair(){
        setName("chair");
        setPrice(199D);
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
     * Clone the chair product
     * @return chair
     */
    @Override
    public Chair clone() {
        Chair chair = new Chair();
        chair.setName(this.getName());
        return chair;
    }
}
