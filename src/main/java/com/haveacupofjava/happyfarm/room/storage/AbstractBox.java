package com.haveacupofjava.happyfarm.room.storage;

import com.haveacupofjava.happyfarm.produce.AbstractProduce;
import com.haveacupofjava.happyfarm.product.AbstractProduct;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBox extends AbstractProduct{

    /**
     * storage the produces
     */
    private List<AbstractProduce> produces;

//    /**
//     * storage the products
//     */
    private List<AbstractProduct> products;

    /**
     * get products container
     * @return
     */
    public List<AbstractProduct> getProducts() {
        if(null == products){
            products = new ArrayList<>();
        }
        return products;
    }

    /**
     * get produces container
     * @return
     */
    public List<AbstractProduce> getProduces() {
        if(null == produces){
            produces = new ArrayList<>();
        }
        return produces;
    }

    /**
     * storage product
     * @param name
     */
    public abstract void storage(List<AbstractProduct> products, AbstractProduce produce);
}
