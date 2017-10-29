package com.haveacupofjava.happyfarm.product;

import com.haveacupofjava.happyfarm.field.AbstractField;

public class Sprinkler extends AbstractTool {

    public Sprinkler() {
        setName("sprinkler");
        setPrice(299D);
    }

    @Override
    public boolean isNil() {
        return false;
    }

    @Override
    public Sprinkler clone() {
        Sprinkler srpinkler = new Sprinkler();
        srpinkler.setName(this.getName());
        return srpinkler;
    }

    @Override
    public void handleField(AbstractField filed) {
        // TODO: implement the library implemented bool
    }

}
