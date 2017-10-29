package com.haveacupofjava.happyfarm.store;

import com.haveacupofjava.happyfarm.product.AbstractProduct;

/**
 * @author Create by xuantang
 * @date on 10/29/17
 */
public abstract class AbstractStore {

    /**
     * Buy product through product name
     * @param name product name
     * @return AbstractProduct
     */
    public abstract AbstractProduct buy(String name);

    /**
     * The items in the room have
     */
    public abstract void show();

}
