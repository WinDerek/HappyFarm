package com.haveacupofjava.happyfarm.room;

import com.haveacupofjava.happyfarm.product.AbstractProduct;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRoom {
    protected Cleanable cleanable;
    protected List<AbstractProduct> products;

    /**
     * clean the room
     */
    public abstract void clean();

    /**
     * show all the goods in the room
     */
    public void show() {
        if(null != products){
            System.out.println("there is no any product in the room");
        }else{
            System.out.println("the items in the room as follows: ");
            for(AbstractProduct abstractProduct : products){
                System.out.println(abstractProduct.name);
            }
        }
    }

    /**
     * add the clean way
     * @param cleanable
     */
    public void setCleanable(Cleanable cleanable) {
        this.cleanable = cleanable;
    }

    public void addProduct(AbstractProduct abstractProduct){
        if(null == products){
            products = new ArrayList<>();
        }
        products.add(abstractProduct);
        System.out.println("add product in the room");
    }
}
