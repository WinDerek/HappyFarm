package com.haveacupofjava.happyfarm.product;

import com.haveacupofjava.happyfarm.field.AbstractField;

public class Sickle extends AbstractTool{
    public Sickle() {
        this.name = "sickle";
    }

    @Override
    public Sickle clone(){
        Sickle sickle = new Sickle();
        sickle.name = this.name;
        return sickle;
    }

    @Override
    public void handleField(AbstractField filed) {

    }
}
