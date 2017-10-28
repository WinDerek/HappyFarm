package com.haveacupofjava.happyfarm.product;

public class Purse extends AbstractDaily {
    public Purse() {
        setName("purse");
        setPrice(99D);
    }

    @Override
    public boolean isNil() {
        return false;
    }

    @Override
    public AbstractProduct clone() {
        return null;
    }
}
