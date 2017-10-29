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
     * Get
     * @return
     */
    public List<Cleanable> getCleanables() {
        if(null == cleanables){
            cleanables = new ArrayList<>();
        }
        return cleanables;
    }

    /**
     * clean interface
     */
    protected List<Cleanable> cleanables;

    /**
     * Items in the room
     */
    protected List<AbstractProduct> products;

    /**
     * Clean the room and execute action
     * @param action the name of action
     */
    public void clean(String action){
        if(null != cleanables){
            for(Cleanable cleanable : cleanables){
                if(cleanable.getClass().getSimpleName().toLowerCase().equals(action)){
                    cleanable.clean();
                    return;
                }
            }
            System.out.println("Fail to clean, cause by : there is no '" + action + "' action");
            System.out.println("List actions : ");
            int index = 0;
            for(Cleanable cleanable : getCleanables()){
                System.out.println(index++ + ". " + cleanable.getClass().getSimpleName());
            }
        }else{
            System.out.println("There is not a clean way");
        }
    }

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
    public void addCleanable(Cleanable cleanable) {
        if(null == cleanables){
            cleanables = new ArrayList<>();
        }
        cleanables.add(cleanable);
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
