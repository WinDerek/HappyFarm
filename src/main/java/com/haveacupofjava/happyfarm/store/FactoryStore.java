package com.haveacupofjava.happyfarm.store;

import com.haveacupofjava.happyfarm.product.*;

import java.util.HashMap;

public class FactoryStore extends AbstractStore {

    private static HashMap<String, AbstractProduct> hashMap = new HashMap<>();

    public FactoryStore() {
        // init the factory and add init products
        hashMap.put("sickle", new Sickle());
        hashMap.put("sprinkler", new Sprinkler());
        hashMap.put("purse", new Purse());
        hashMap.put("bed", new Bed());
        hashMap.put("hoe", new Hoe());
        hashMap.put("desk", new Desk());
        hashMap.put("chair", new Chair());
    }

    /**
     * TODO: Improve this method
     * @param name
     * @param tool
     */
    public static void addTool(String name, AbstractTool tool) {
        try {
            hashMap.put(name, tool);
            System.out.println("Success to add :" + name);
        } catch (Exception exception) {
            exception.printStackTrace(System.out);
        }
    }

    /**
     * Buy product through product name
     * @param name product name
     * @return AbstractProduct
     */
    @Override
    public AbstractProduct buy(String name) {
        // check if product exist in the factory
        if (hashMap.keySet().contains(name)) {
            System.out.println("Success to buy : " + name);
            return hashMap.get(name).clone();
        } else {
            System.out.println("Fail to buy : " + name +
                    ", caused by: the store did not sell " + name);
            return new NullProduct();
        }
    }

    @Override
    public void show() {
        if (null != hashMap) {
            System.out.println("Show the products in the store: ");
            for (String name : hashMap.keySet()) {
                System.out.println(name);
            }
        } else {
            System.out.println("There is no product in the store");
        }
    }

}
