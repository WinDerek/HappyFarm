package com.haveacupofjava.happyfarm.room.storage;

import com.haveacupofjava.happyfarm.produce.AbstractProduce;
import com.haveacupofjava.happyfarm.product.AbstractProduct;

import java.util.List;

public abstract class Box extends AbstractProduct{

    public List<AbstractProduce> getProduces() {
        return produces;
    }

    public void setProduces(List<AbstractProduce> produces) {
        this.produces = produces;
    }

    private List<AbstractProduce> produces;

    public List<AbstractProduct> getProducts() {
        return products;
    }

    public void setProducts(List<AbstractProduct> products) {
        this.products = products;
    }

    private List<AbstractProduct> products;

    /**
     * storage product
     * @param name
     */
    public abstract void storage(AbstractProduce produce);
}
