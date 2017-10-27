package com.haveacupofjava.happyfarm.product;

public class Hoe extends AbstractTool{
    public Hoe() {
        setName("hoe");
    }


    @Override
    public Hoe clone() {
        Hoe hoe = new Hoe();
        hoe.setName(this.getName());
        return hoe;
    }
}
