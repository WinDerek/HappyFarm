package com.haveacupofjava.happyfarm.product;

public class Purse extends AbstractDaily {
    public Purse() {
        setName("purse");
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
