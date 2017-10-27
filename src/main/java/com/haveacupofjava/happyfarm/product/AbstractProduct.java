package com.haveacupofjava.happyfarm.product;

public abstract class AbstractProduct {

    public String name;

    /**
     * clone the product
     * @return
     */
    public abstract AbstractProduct clone();

}
