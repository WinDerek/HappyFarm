package com.haveacupofjava.happyfarm.product;

public abstract class AbstractProduct {

    private String name;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    /**
     * clone the product
     * @return
     */
    public abstract AbstractProduct clone();

}
