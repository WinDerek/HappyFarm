package com.haveacupofjava.happyfarm.store;

import com.haveacupofjava.happyfarm.product.*;

import java.util.HashMap;

public class FactoryStore extends AbstractStore {

    private HashMap<String, AbstractProduct> hashMap;

    public FactoryStore(){
        // init the factory and add init products
        hashMap = new HashMap<>();
        hashMap.put("sickle", new Sickle());
        hashMap.put("spinkler", new Spinkler());
        hashMap.put("purse", new Purse());
        hashMap.put("bed", new Bed());
        hashMap.put("hoe", new Hoe());
        hashMap.put("desk", new Desk());
        hashMap.put("chair", new Chair());
    }



    @Override
    public AbstractProduct buy(String name) {
        // check if product exist in the factory
        if(hashMap.keySet().contains(name)){
            System.out.println("Success to buy : " + name);
            return hashMap.get(name).clone();
        }else {
            System.out.println("Fail to buy : " + name + ", caused by: the store did not sell " + name);
            return new NullProduct();
        }
    }

    @Override
    public void show() {
        if(null != hashMap){
            System.out.println("Show the products in the store: ");
            for (String name : hashMap.keySet()){
                System.out.println(name);
            }
        }else{
            System.out.println("there is no product in the store");
        }
    }

}
