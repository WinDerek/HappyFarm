package com.haveacupofjava.happyfarm.product;

public class Bed extends AbstractFurniture {

    @Override
    public Bed clone() {
        Bed bed = new Bed();
        bed.name = this.name;
        return bed;
    }
}
