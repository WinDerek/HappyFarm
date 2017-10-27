package com.haveacupofjava.happyfarm.room.storage;

import com.haveacupofjava.happyfarm.produce.AbstractProduce;
import com.haveacupofjava.happyfarm.product.AbstractProduct;

public class MeatBox extends SpecialBox {

    public MeatBox(){
        setName("meatBox");
    }
    @Override
    public void storage(AbstractProduce produce) {
        getProduces().add(produce);
        System.out.println("storage meat in the box");
    }

    @Override
    public AbstractProduct clone() {
        return null;
    }
}
