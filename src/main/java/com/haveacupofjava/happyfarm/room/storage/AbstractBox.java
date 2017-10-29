package com.haveacupofjava.happyfarm.room.storage;

import com.haveacupofjava.happyfarm.produce.AbstractProduce;
import com.haveacupofjava.happyfarm.product.AbstractProduct;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Create by xuantang
 * @date on 10/29/17
 */
public abstract class AbstractBox extends AbstractProduct{

    /**
     * store the produces
     */
    private List<AbstractProduce> produces;

//    /**
//     * store the products
//     */
    private List<AbstractProduct> products;

    /**
     * Get products container
     * @return The list of AbstractProduct
     */
    public List<AbstractProduct> getProducts() {
        if(null == products){
            products = new ArrayList<>();
        }
        return products;
    }

    /**
     * Ｇet produces container
     * @return The list of AbstractProduce
     */
    public List<AbstractProduce> getProduces() {
        if(null == produces){
            produces = new ArrayList<>();
        }
        return produces;
    }

    /**
     * Store produce to box and save in products list
     * @param products products list
     * @param produce the produce will be stored
     */
    public abstract void store(List<AbstractProduct> products, AbstractProduce produce);
}
