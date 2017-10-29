package com.haveacupofjava.happyfarm.product;

/**
 * @author Create by xuantang
 * @date on 10/29/17
 */
public abstract class AbstractProduct {

    /**
     * Product name
     */
    private String name;

    /**
     * Product price
     */
    private Double price;

    /**
     * Set product price
     * @return
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Set product price
     * @param price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Return the product name
     * @return
     */
    public String getName(){
        return name;
    }

    /**
     * Check whether the object is empty
     * @return boolean
     */
    public abstract boolean isNil();

    /**
     * Update the product name
     * @param name that is product name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Clone the product
     * @return new product
     */
    public abstract AbstractProduct clone();

}
