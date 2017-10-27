package com.haveacupofjava.happyfarm.product;

public class Sickle extends AbstractTool{
    public Sickle() {
        setName("sickle");
    }

    @Override
    public Sickle clone(){
        Sickle sickle = new Sickle();
        sickle.setName(this.getName());
        return sickle;
    }
}
