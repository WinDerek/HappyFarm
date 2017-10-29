package com.haveacupofjava.happyfarm.room.storage;

import com.haveacupofjava.happyfarm.produce.AbstractProduce;
import com.haveacupofjava.happyfarm.product.AbstractProduct;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBox extends AbstractProduct {

    /**
     * store the produces
     */
    private List<AbstractProduce> produces;

    /**
     * store the products
     */
    private List<AbstractProduct> products;

    /**
     * Gets products container
     * @return The list of AbstractProduct
     */
    public List<AbstractProduct> getProducts() {
        if(null == products) {
            products = new ArrayList<>();
        }
        return products;
    }

    /**
     * Gets produces container
     * @return The list of AbstractProduce
     */
    public List<AbstractProduce> getProduces() {
        if(null == produces){
            produces = new ArrayList<>();
        }
        return produces;
    }

    /**
     * Stores produce to box and saves in products list
     * @param products The products list
     * @param produce The produce will be stored
     */
    public abstract void store(List<AbstractProduct> products, AbstractProduce produce);

}
