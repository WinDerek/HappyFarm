package com.haveacupofjava.happyfarm.product;

public abstract class AbstractProduct {

    /**
     * product name
     */
    private String name;

    /**
     * return the product name
     * @return
     */
    public String getName(){
        return name;
    }

    /**
     * check whether the object is empty
     * @return boolean
     */
    public abstract boolean isNil();

    /**
     * update the product name
     * @param name that is product name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * clone the product
     * @return new product
     */
    public abstract AbstractProduct clone();

}
