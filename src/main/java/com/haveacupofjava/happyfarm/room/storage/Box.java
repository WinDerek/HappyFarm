package com.haveacupofjava.happyfarm.room.storage;

import com.haveacupofjava.happyfarm.produce.AbstractProduce;
import com.haveacupofjava.happyfarm.product.AbstractProduct;

import java.util.ArrayList;
import java.util.List;

public abstract class Box extends AbstractProduct{

    public List<AbstractProduce> getProduces() {
        if(null == produces){
            produces = new ArrayList<>();
        }
        return produces;
    }

    private List<AbstractProduce> produces;

    public List<AbstractProduct> getProducts() {
        return products;
    }


    private List<AbstractProduct> products;

    /**
     * storage product
     * @param name
     */
    public abstract void storage(AbstractProduce produce);
}
