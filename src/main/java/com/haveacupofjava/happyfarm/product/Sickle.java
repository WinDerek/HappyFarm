package com.haveacupofjava.happyfarm.product;

import com.haveacupofjava.happyfarm.field.AbstractField;

public class Sickle extends AbstractTool {

    public Sickle() {
        setName("sickle");
        setPrice(59D);
    }

    @Override
    public boolean isNil() {
        return false;
    }

    @Override
    public Sickle clone() {
        Sickle sickle = new Sickle();
        sickle.setName(this.getName());
        return sickle;
    }

    @Override
    public void handleField(AbstractField filed) {
        // TODO: implements the library implemented tool functionality
    }
}
