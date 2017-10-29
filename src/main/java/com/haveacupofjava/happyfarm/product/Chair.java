package com.haveacupofjava.happyfarm.product;

public class Chair extends AbstractFurniture {

    public Chair() {
        setName("chair");
        setPrice(199D);
    }

    @Override
    public boolean isNil() {
        return false;
    }

    @Override
    public Chair clone() {
        Chair chair = new Chair();
        chair.setName(this.getName());
        return chair;
    }

}
