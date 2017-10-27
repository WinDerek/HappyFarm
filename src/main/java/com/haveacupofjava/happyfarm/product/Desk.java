package com.haveacupofjava.happyfarm.product;

public class Desk extends AbstractFurniture {

    @Override
    public Desk clone() {
        Desk desk = new Desk();
        desk.name = this.name;
        return desk;
    }
}
