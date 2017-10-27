package com.haveacupofjava.happyfarm.room.storage;

import com.haveacupofjava.happyfarm.produce.AbstractProduce;
import com.haveacupofjava.happyfarm.product.AbstractProduct;

public class NormalBox extends Box {

    private BoxAdapter boxAdapter;

    public NormalBox(){
        setName("normalBox");
    }


    @Override
    public void storage(AbstractProduce produce) {
        String name = produce.getName();
        // storage special produce
        if(name.equals("meat") || name.equals("milk") || name.equals("fruit")){
            boxAdapter = new BoxAdapter(produce);
            boxAdapter.storage(produce);
            getProducts().add(boxAdapter);
        }else{
            getProduces().add(produce);
            getProducts().add(this);
            System.out.println("storage product in the box");
        }
    }

    @Override
    public AbstractProduct clone() {
        return null;
    }
}
