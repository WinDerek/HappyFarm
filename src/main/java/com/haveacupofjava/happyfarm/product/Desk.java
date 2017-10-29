package com.haveacupofjava.happyfarm.product;

/**
 * @author Create by xuantang
 * @date on 10/29/17
 */
public class Desk extends AbstractFurniture {

    public Desk(){
        setName("desk");
        setPrice(999D);
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
    public Desk clone() {
        Desk desk = new Desk();
        desk.setName(this.getName());
        return desk;
    }
}
