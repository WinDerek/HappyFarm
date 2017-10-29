package com.haveacupofjava.happyfarm.product;

public class Bed extends AbstractFurniture {

    public Bed() {
        setName("bed");
        setPrice(2999D);
    }

    @Override
    public boolean isNil() {
        return false;
    }

    @Override
    public Bed clone() {
        Bed bed = new Bed();
        bed.setName(this.getName());
        return bed;
    }

}
