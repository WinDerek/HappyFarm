package com.haveacupofjava.happyfarm.room;

import com.haveacupofjava.happyfarm.product.AbstractProduct;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Create by xuantang
 * @date on 10/29/17
 */
public abstract class AbstractRoom implements Serializable{


    /**
     * room name
     */
    private String name;
    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * clean interface
     */
    protected Cleanable cleanable;

    /**
     * Items in the room
     */
    protected List<AbstractProduct> products;

    /**
     * Clean the room
     */
    public abstract void clean();

    /**
     * Show all the items in the room
     */
    public void show() {
        if(null == products){
            System.out.println("There is nothing in the room");
        }else{
            System.out.println("The items in the room as follows: ");
            for(AbstractProduct abstractProduct : products){
                System.out.println(abstractProduct.getName());
            }
        }
    }

    /**
     * Add the clean way
     * @param cleanable
     */
    public void setCleanable(Cleanable cleanable) {
        this.cleanable = cleanable;
    }

    /**
     * Add product in the room
     * @param abstractProduct
     */
    public void addProduct(AbstractProduct abstractProduct){
        if(null == products){
            products = new ArrayList<>();
        }
        products.add(abstractProduct);
        System.out.println("Success to add the " + abstractProduct.getName() + " to the " + getName());
    }

}
