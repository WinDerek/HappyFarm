package com.haveacupofjava.happyfarm.product;

public class Purse extends AbstractDaily {
    public Purse() {
        setName("purse");
    }

    @Override
    public AbstractProduct clone() {
        return null;
    }
}
