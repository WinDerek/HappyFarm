package com.haveacupofjava.happyfarm.product;

public class Spinkler extends AbstractTool {

    public Spinkler() {
        this.name = "spinkler";
    }

    @Override
    public Spinkler clone() {
        Spinkler spinkler = new Spinkler();
        spinkler.name = this.name;
        return spinkler;
    }
}
