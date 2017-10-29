package com.haveacupofjava.happyfarm.product;

public abstract class AbstractProduct {

    private String name;

    private Double price;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName(){
        return name;
    }

    /**
     * Checks whether the object is empty
     * @return boolean
     */
    public abstract boolean isNil();

    public void setName(String name){
        this.name = name;
    }

    /**
     * Clones the product and returns a new one
     * @return A new product
     */
    public abstract AbstractProduct clone();

}
