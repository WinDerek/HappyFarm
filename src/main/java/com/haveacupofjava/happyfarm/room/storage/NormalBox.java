package com.haveacupofjava.happyfarm.room.storage;

import com.haveacupofjava.happyfarm.produce.AbstractProduce;
import com.haveacupofjava.happyfarm.product.AbstractProduct;

public class NormalBox extends AbstractBox {

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
        }else{
            getProduces().add(produce);
            System.out.println("storage produce in the box");
        }
    }

    @Override
    public boolean isNil() {
        return false;
    }

    @Override
    public AbstractProduct clone() {
        return null;
    }
}
