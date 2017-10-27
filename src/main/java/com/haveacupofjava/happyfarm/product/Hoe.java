package com.haveacupofjava.happyfarm.product;

import com.haveacupofjava.happyfarm.field.AbstractField;

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

    @Override
    public void handleField(AbstractField filed) {

    }
}


