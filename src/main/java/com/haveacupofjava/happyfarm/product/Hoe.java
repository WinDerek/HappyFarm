package com.haveacupofjava.happyfarm.product;

import com.haveacupofjava.happyfarm.field.AbstractField;

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

    @Override
    public void handleField(AbstractField filed) {

    }
}


