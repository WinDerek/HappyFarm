package com.haveacupofjava.happyfarm.product;

public class Chair extends AbstractFurniture {
    @Override
    public Chair clone() {
        Chair chair = new Chair();
        chair.name = this.name;
        return chair;
    }
}
