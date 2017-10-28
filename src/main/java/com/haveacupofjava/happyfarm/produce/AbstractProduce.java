package com.haveacupofjava.happyfarm.produce;

public abstract class AbstractProduce {

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    private String name;
    private double price;

}
