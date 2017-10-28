package com.haveacupofjava.happyfarm.room;

import com.haveacupofjava.happyfarm.product.AbstractProduct;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRoom {


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
     * items in the room
     */
    protected List<AbstractProduct> products;

    /**
     * clean the room
     */
    public abstract void clean();

    /**
     * show all the items in the room
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
     * add the clean way
     * @param cleanable
     */
    public void setCleanable(Cleanable cleanable) {
        this.cleanable = cleanable;
    }

    /**
     * add product in the room
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
