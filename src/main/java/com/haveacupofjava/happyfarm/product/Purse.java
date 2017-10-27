package com.haveacupofjava.happyfarm.product;

public class Purse extends AbstractDaily {
    public Purse() {
        this.name = "purse";
    }

    @Override
    public AbstractProduct clone() {
        return null;
    }
}
