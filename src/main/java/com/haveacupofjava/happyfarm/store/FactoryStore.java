package com.haveacupofjava.happyfarm.store;

import com.haveacupofjava.happyfarm.product.*;

import java.util.HashMap;

public class FactoryStore extends AbstractStore {

    private HashMap<String, AbstractProduct> hashMap;

    public FactoryStore(){
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
        if(hashMap.keySet().contains(name)){
            return hashMap.get(name).clone();
        }else {
            return new NullProduct();
        }
    }

    @Override
    public void show() {
        if(null != hashMap){
            System.out.println("this store has product as follow: ");
            for (String name : hashMap.keySet()){
                System.out.println(name);
            }
        }else{
            System.out.println("this store has no product");
        }
    }
}
