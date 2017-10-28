package com.haveacupofjava.happyfarm.produce;

import java.io.Serializable;

public abstract class AbstractProduce implements Serializable {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

}
