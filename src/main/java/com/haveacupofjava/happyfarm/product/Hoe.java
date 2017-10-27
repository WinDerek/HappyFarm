package com.haveacupofjava.happyfarm.product;

public class Hoe extends AbstractTool{
    public Hoe() {
        this.name = "hoe";
    }


    @Override
    public Hoe clone() {
        Hoe hoe = new Hoe();
        hoe.name = this.name;
        return hoe;
    }
}
