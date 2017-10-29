package com.haveacupofjava.happyfarm.product;

public class Desk extends AbstractFurniture {

    public Desk() {
        setName("desk");
        setPrice(999D);
    }

    @Override
    public boolean isNil() {
        return false;
    }

    @Override
    public Desk clone() {
        Desk desk = new Desk();
        desk.setName(this.getName());
        return desk;
    }

}
