package com.haveacupofjava.happyfarm.product;

public class Spinkler extends AbstractTool {

    public Spinkler() {
        setName("spinkler");
    }


    @Override
    public boolean isNil() {
        return false;
    }

    @Override
    public Spinkler clone() {
        Spinkler spinkler = new Spinkler();
        spinkler.setName(this.getName());
        return spinkler;
    }
}
