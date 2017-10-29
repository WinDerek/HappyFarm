package com.haveacupofjava.happyfarm.product;

import com.haveacupofjava.happyfarm.field.AbstractField;

public class Hoe extends AbstractTool{

    public Hoe() {
        setName("hoe");
        setPrice(99D);
    }

    @Override
    public boolean isNil() {
        return false;
    }

    @Override
    public Hoe clone() {
        Hoe hoe = new Hoe();
        hoe.setName(this.getName());
        return hoe;
    }

    @Override
    public void handleField(AbstractField filed) {
        // TODO: implements this library implemented tool
    }

}


